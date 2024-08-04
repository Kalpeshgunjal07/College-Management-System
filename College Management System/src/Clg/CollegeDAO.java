package Clg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollegeDAO {
    public void addCollege(College college) {
        String sql = "INSERT INTO college (name, address, contact, departments_count, department_name) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, college.getName());
            statement.setString(2, college.getAddress());
            statement.setString(3, college.getContact());
            statement.setInt(4, college.getDepartmentsCount());
            statement.setString(5, college.getDepartmentName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<College> getAllColleges() {
        List<College> colleges = new ArrayList<>();
        String sql = "SELECT * FROM college";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                College college = new College();
                college.setId(resultSet.getInt("id"));
                college.setName(resultSet.getString("name"));
                college.setAddress(resultSet.getString("address"));
                college.setContact(resultSet.getString("contact"));
                college.setDepartmentsCount(resultSet.getInt("departments_count"));
                college.setDepartmentName(resultSet.getString("department_name"));
                colleges.add(college);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colleges;
    }

    public void updateCollege(College college) {
        String sql = "UPDATE college SET name = ?, address = ?, contact = ?, departments_count = ?, department_name = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, college.getName());
            statement.setString(2, college.getAddress());
            statement.setString(3, college.getContact());
            statement.setInt(4, college.getDepartmentsCount());
            statement.setString(5, college.getDepartmentName());
            statement.setInt(6, college.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCollege(int id) {
        String sql = "DELETE FROM college WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

