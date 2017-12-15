package me.toxicmushroom.pixelbungeecore.dbs;

import me.toxicmushroom.pixelbungeecore.PixelCore;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.sql.*;
import java.util.ArrayList;

public class MySQL {
    private Connection con;
    private String HOST, DATABASE, USER, PASSWORD;
    public void connect(String host, String database, String user, String password) {
        HOST = host;
        DATABASE = database;
        USER = user;
        PASSWORD = password;
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database + "?autoReconnect=true", user, password);
            System.out.println("[MySQL] has connected");
        } catch (SQLException e) {
            System.out.println("[MySQL] did not connect error: " + e.getMessage());
        }
    }
    private void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":3306/" + DATABASE + "?autoReconnect=true", USER, PASSWORD);
            System.out.println("[MySQL] has connected");
        } catch (SQLException e) {
            System.out.println("[MySQL] did not connect error: " + e.getMessage());
        }
    }
    public void close() {
        try {
            if (this.con != null) {
                this.con.close();
                System.out.println("[MySQL] has disconnected");
            }
        } catch (SQLException e) {
            System.out.println("[MySQL] did not disconnect proparily error:" + e.getMessage());
        }
    }
    public void update(String qry) {
        try {
            Statement st = this.con.createStatement();
            st.executeUpdate(qry);
            st.close();
        } catch (SQLException e) {
            connect();
            System.err.println(e);
        }
    }
    private ResultSet query(String qry) {
        ResultSet rs = null;
        try {
            Statement st = this.con.createStatement();
            rs = st.executeQuery(qry);
        } catch (SQLException e) {
            connect();
            System.err.println(e);
        }
        return rs;
    }

    public String getPrimairyGroup(ProxiedPlayer p) {
        try {
            PreparedStatement primarygroup = con.prepareStatement("SELECT primary_group FROM luckperms_players WHERE uuid= ?");
            primarygroup.setString(1, p.getUniqueId().toString());
            ResultSet rs = primarygroup.executeQuery();
            if (rs.next()) return rs.getString("primary_group");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "default";
    }
    public boolean isVanishedPlayer(ProxiedPlayer p) {
        try {
            PreparedStatement isvanished = con.prepareStatement("SELECT * FROM vanished WHERE UUID=?");
            isvanished.setString(1, p.getUniqueId().toString());
            ResultSet rs = isvanished.executeQuery();
            if (rs.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
