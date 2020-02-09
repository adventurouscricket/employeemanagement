package com.mrhenry.repository.impl;

import com.mrhenry.entity.EmployeeEntity;
import com.mrhenry.repository.IEmployeeRepository;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    //init connection to DB
    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/employeemanagement";
            String user = "root";
            String password = "vuphuong2811";
            return DriverManager.getConnection(databaseURL, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(EmployeeEntity entity, Long id) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sql = "UPDATE employee SET name= ?, grid =? WHERE id = ?";

            statement = conn.prepareStatement(sql);

            if(conn != null) {
                //set parameter to statement
                statement.setObject(1, entity.getName());
                statement.setObject(2, entity.getGrid());
                statement.setObject(3, entity.getId());
                statement.executeUpdate();
                conn.commit();
            }

        } catch(SQLException e) {
            if(conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
                if(statement != null) {
                    statement.close();
                }
            } catch(SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    public Long insert(EmployeeEntity entity) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO employee (name, grid) VALUES (?, ?)";

            statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            if(conn != null) {
                //set parameter to statement
                statement.setObject(1,entity.getName());
                statement.setObject(2, entity.getGrid());
                int rowsInserted = statement.executeUpdate();
                conn.commit();
                resultSet = statement.getGeneratedKeys();
                if(rowsInserted > 0) {
                    while(resultSet.next()) {
                        Long id = resultSet.getLong(1);
                        return id;
                    }
                }
            }
        } catch(SQLException e) {
            if(conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
                if(statement != null) {
                    statement.close();
                }
            } catch(SQLException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public void delete(Long id) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlQuery = "DELETE FROM employee WHERE id=?";

            statement = conn.prepareStatement(sqlQuery);

            if(conn != null) {
                statement.setObject(1, id);
                statement.executeUpdate();
                conn.commit();
            }

        } catch(SQLException e) {
            if(conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
                if(statement != null) {
                    statement.close();
                }
            } catch(SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    public List<EmployeeEntity> findAll() {

        List<EmployeeEntity> resutls = new ArrayList<>();
        try {
            String sql = "SELECT * FROM employee ORDER BY grid, id";
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            if (conn != null) {
                ResultSetMetaData rsMetaData = rs.getMetaData();
                //row
                while (rs.next()) {
                    EmployeeEntity entity = new EmployeeEntity();
                    //get metadata in row
                    for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
                        String columnName = rsMetaData.getColumnName(i + 1);
                        Object columnValue = rs.getObject(i + 1);

                        //current class
                        if (columnValue != null) {
                            if (columnName.equals("id")) {
                                BeanUtils.setProperty(entity, "id", columnValue);
                            } else if (columnName.equals("name")) {
                                BeanUtils.setProperty(entity, "name", columnValue);
                            } else if (columnName.equals("grid")) {
                                BeanUtils.setProperty(entity, "grid", columnValue);
                            }
                        }
                    }
                    resutls.add(entity);
                }
            }
        }catch(SQLException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
        return resutls;
    }

    @Override
    public EmployeeEntity findById(Long id) {
        List<EmployeeEntity> resutls = new ArrayList<>();
        try {
            String sql = "SELECT * FROM employee WHERE id=?";
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setObject(1, id);
            ResultSet rs = statement.executeQuery();

            if (conn != null) {
                ResultSetMetaData rsMetaData = rs.getMetaData();
                //row
                while (rs.next()) {
                    EmployeeEntity entity = new EmployeeEntity();
                    //get metadata in row
                    for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
                        String columnName = rsMetaData.getColumnName(i + 1);
                        Object columnValue = rs.getObject(i + 1);

                        //current class
                        if (columnValue != null) {
                            if (columnName.equals("id")) {
                                BeanUtils.setProperty(entity, "id", columnValue);
                            } else if (columnName.equals("name")) {
                                BeanUtils.setProperty(entity, "name", columnValue);
                            } else {
                                BeanUtils.setProperty(entity, "grId", columnValue);
                            }
                        }
                        resutls.add(entity);
                    }
                    resutls.get(0);
                }

            }
        }catch(SQLException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
