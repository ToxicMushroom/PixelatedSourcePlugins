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

    public MySQL(String host, String database, String user, String password) {
        this.HOST = host;
        this.DATABASE = database;
        this.USER = user;
        this.PASSWORD = password;
        connect();
    }

    private void connect() {
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://" + this.HOST + ":3306/" + this.DATABASE + "?autoReconnect=true",
                    this.USER, this.PASSWORD);
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

    public static void addVanishedPlayer(Player p) {
        Main.mySQL.update("INSERT INTO vanished (name, UUID), ('" + p.getName() + "', '" + p.getUniqueId().toString() + "')");
    }
    public static void removeVanishedPlayer(Player p) {
        Main.mySQL.update("DELETE FROM vanished WHERE UUID= '" + p.getUniqueId().toString() +"'");
    }
    public static boolean isVanishedPlayer(Player p) {
        ResultSet rs = Main.mySQL.query("SELECT FROM vanished WHERE UUID= '" + p.getUniqueId().toString() + "'");
        boolean ivp = false;
        try {
            while (rs.next()) {
                ivp = true;
            }
        } catch (SQLException ignored) {
            ignored.printStackTrace();
        }
        return ivp;
    }
}
