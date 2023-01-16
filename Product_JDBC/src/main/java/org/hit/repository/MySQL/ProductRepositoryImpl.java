package org.hit.repository.MySQL;

import org.hit.model.Product;
import org.hit.repository.ProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private Connection connection;
    int ch=0;

    public ProductRepositoryImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/product";
            String username="******"; //set your own username
            String password="******"; //set your own password
            connection= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Product addProduct(Product product) {
        String sql="INSERT INTO productdetails VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,product.getProductId());
            ps.setString(2,product.getProductName());
            ps.setInt(3,product.getProductPrice());
            ps.setInt(4,product.getStock());
            ps.setString(5,product.getUnit());
            ch=ps.executeUpdate();
            if(ch>0){
                return product;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        String sql="UPDATE productdetails SET ProductName=?,Price=?,Stock=?,Unit=? WHERE ProductID=? ";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,product.getProductName());
            ps.setInt(2,product.getProductPrice());
            ps.setInt(3,product.getStock());
            ps.setString(4,product.getUnit());
            ps.setInt(5,product.getProductId());
            ch=ps.executeUpdate();
            if(ch>0){
                return product;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product deleteProduct(Integer productId) {
        String sql="DELETE FROM productdetails WHERE ProductID=?";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,productId);
            ch=ps.executeUpdate();
            if (ch>0){
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        ArrayList<Product> list=new ArrayList<>();

        String sql="SELECT * FROM productdetails";
        try {
            Statement st=connection.createStatement();
            ResultSet res=st.executeQuery(sql);
            while (res.next()){
                list.add(new Product(res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4),res.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Product findById(Integer productId) {
        String sql="SELECT * FROM productdetails WHERE ProductID=?";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,productId);
            ResultSet res=ps.executeQuery();

            if (res.next()){
                return new Product(res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4),res.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
