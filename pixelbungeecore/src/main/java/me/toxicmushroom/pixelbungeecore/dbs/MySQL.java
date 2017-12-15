package me.toxicmushroom.pixelbungeecore.dbs;

import me.toxicmushroom.pixelbungeecore.Config;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.config.Configuration;

import java.sql.*;

public class MySQL {
    private Connection con;
    public MySQL() {
        if (con == null) {
            connect();
        }
    }

    private void connect() {
        Configuration config = Config.configuration;
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + config.getString("mysql.ipadress") + ":3306/" + config.getString("mysql.database") + "?autoReconnect=true",
                    config.getString("mysql.username"), config.getString("mysql.password"));
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
        if (con == null) connect();
        try {
            PreparedStatement primarygroup = con.prepareStatement("SELECT primary_group FROM luckperms_players WHERE uuid=?");
            primarygroup.setString(1, p.getUniqueId().toString());
            ResultSet rs = primarygroup.executeQuery();
            if (rs.next()) return rs.getString("primary_group");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "default";
    }

    public boolean isVanishedPlayer(ProxiedPlayer p) {
        if (con == null) connect();
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
