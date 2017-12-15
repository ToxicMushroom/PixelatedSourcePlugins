package be.pixelnetwork.core.databases;

import be.pixelnetwork.core.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import java.sql.*;

public class MySQL {
    private Connection con;
    public MySQL() {
        if (con == null) {
            connect();
        }
    }

    public void connect() {
        FileConfiguration config = Main.getInstance().getConfig();
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
        if (con == null) connect();
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
        if (con == null) connect();
        try {
            PreparedStatement removevanished = con.prepareStatement("DELETE FROM vanished WHERE UUID= ?");
            removevanished.setString(1, p.getUniqueId().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isVanishedPlayer(Player p) {
        if (con == null) connect();
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
