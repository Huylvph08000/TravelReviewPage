package dao.impl;

import dao.IDoctorDao;
import model.DoctorModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO implements IDoctorDao {


    public Connection getConnection() {
        Connection connection = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcURL = "jdbc:mysql://localhost:3306/doctor?useSSL=false";
            String jdbcUsername = "root";
            String jdbcPassword = "root";
            return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    @Override
    public List<DoctorModel> findAll() {
        List<DoctorModel> results = new ArrayList<>();
        String sql = "SELECT * FROM doctorlist";
        //open connection
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    DoctorModel doctor = new DoctorModel();
                    doctor.setId(resultSet.getLong("id"));
                    doctor.setName(resultSet.getString("name"));
                    doctor.setGender(resultSet.getBoolean("gender"));
                    doctor.setNationality(resultSet.getString("nationality"));
                    doctor.setAddress(resultSet.getString("address"));
                    doctor.setPhone(resultSet.getString("phone"));
                    doctor.setEducation(resultSet.getString("education"));
                    doctor.setPosition(resultSet.getString("position"));
                    doctor.setHospital(resultSet.getString("hospital"));
                    results.add(doctor);
                }
                return results;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }
}
