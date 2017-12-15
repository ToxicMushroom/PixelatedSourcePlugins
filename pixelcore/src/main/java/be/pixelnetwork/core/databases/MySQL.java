package be.pixelnetwork.core.databases;

import be.pixelnetwork.core.Main;
import org.bukkit.entity.Player;

import java.sql.*;

public class MySQL {
    private String HOST;
    private String DATABASE;
    private String USER;
    private String PASSWORD;
    private Connection con;


    public void connect(String host, String database, String user, String password) {
        HOST = host;
        DATABASE = database;
        USER = user;
        PASSWORD = password;
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://" + this.HOST + ":3306/" + this.DATABASE + "?autoReconnect=true",
                    this.USER, this.PASSWORD);
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

    public ResultSet query(String qry) {
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

    public void addVanishedPlayer(Player p) {
        try {
            PreparedStatement addvanished = con.prepareStatement("INSERT INTO vanished (name, UUID) VALUES (?, ?)");
            addvanished.setString(1, p.getName());
            addvanished.setString(2, p.getUniqueId().toString());
            addvanished.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeVanishedPlayer(Player p) {
        try {
            PreparedStatement removevanished = con.prepareStatement("DELETE FROM vanished WHERE UUID= ?");
            removevanished.setString(1, p.getUniqueId().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isVanishedPlayer(Player p) {
        try {
            PreparedStatement isvanished = con.prepareStatement("SELECT * FROM vanished WHERE UUID=?");
            isvanished.setString(1, p.getUniqueId().toString());
            ResultSet rs = isvanished.executeQuery();
            if (rs.next()) return true;
        } catch (SQLException ignored) {
            ignored.printStackTrace();
        }
        return false;
    }
}