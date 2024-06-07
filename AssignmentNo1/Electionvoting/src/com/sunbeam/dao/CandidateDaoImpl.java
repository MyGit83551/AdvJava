package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entity.Candidate;

public class CandidateDaoImpl {
    private Connection connection;

    public CandidateDaoImpl() throws SQLException {
        // Establish database connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/election_db", "username", "password");
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public List<Candidate> findAll() throws SQLException {
        List<Candidate> candidates = new ArrayList<>();
        String query = "SELECT * FROM candidates";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                candidates.add(extractCandidateFromResultSet(resultSet));
            }
        }
        return candidates;
    }

    public List<Candidate> findByParty(String party) throws SQLException {
        List<Candidate> candidates = new ArrayList<>();
        String query = "SELECT * FROM candidates WHERE party = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, party);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    candidates.add(extractCandidateFromResultSet(resultSet));
                }
            }
        }
        return candidates;
    }

    public List<Candidate> findAllOrderByVotesDesc() throws SQLException {
        List<Candidate> candidates = new ArrayList<>();
        String query = "SELECT * FROM candidates ORDER BY votes DESC";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                candidates.add(extractCandidateFromResultSet(resultSet));
            }
        }
        return candidates;
    }

    public int save(Candidate c) throws SQLException {
        String query = "INSERT INTO candidates (name, party, votes) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, c.getName());
            statement.setString(2, c.getParty());
            statement.setInt(3, c.getVotes());
            return statement.executeUpdate();
        }
    }

    public int deleteById(int id) throws SQLException {
        String query = "DELETE FROM candidates WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        }
    }

    public int update(Candidate c) throws SQLException {
        String query = "UPDATE candidates SET name = ?, party = ?, votes = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, c.getName());
            statement.setString(2, c.getParty());
            statement.setInt(3, c.getVotes());
            statement.setInt(4, c.getId());
            return statement.executeUpdate();
        }
    }

    public Candidate findById(int id) throws SQLException {
        String query = "SELECT * FROM candidates WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractCandidateFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    public int incrementVotes(int id) throws SQLException {
        String query = "UPDATE candidates SET votes = votes + 1 WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        }
    }

    private Candidate extractCandidateFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String party = resultSet.getString("party");
        int votes = resultSet.getInt("votes");
        return new Candidate(id, name, party, votes);
    }
}
