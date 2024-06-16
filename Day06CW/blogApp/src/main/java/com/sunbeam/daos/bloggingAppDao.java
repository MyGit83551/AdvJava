package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


import com.mysql.cj.protocol.Resultset;
import com.sunbeam.pojos.Blogs;
import com.sunbeam.pojos.Categories;
import com.sunbeam.utils.DbUtil;

public class bloggingAppDao implements AutoCloseable
{
	private Connection connection;

	public bloggingAppDao() throws SQLException 
	{
		connection = DbUtil.getConnection();
	}
	
	public void addCategory(Categories c) throws SQLException
	{
		String sql = "Insert into  categories (title,description) values (?,?)";
		try(PreparedStatement stmt = connection.prepareStatement(sql))
		{
			stmt.setString(1, c.getTitle());
			stmt.setString(2,c.getDescription());
			stmt.executeUpdate();
		}
	}
	
	
	public List<Categories> showCategory() throws SQLException
	{
		String sql = "Select * from categories";
		List<Categories> categoryList = null;
		try(PreparedStatement stmt = connection.prepareStatement(sql))
		{
			ResultSet rs = stmt.executeQuery();
			categoryList = new ArrayList<Categories>();
			while(rs.next())
			{
				Categories categories = new Categories();
				categories.setTitle(rs.getString("title"));
				categories.setDescription(rs.getString("description"));
				categoryList.add(categories);
			}
		}
		return categoryList;
	}
	
	
	public void addBlogs(Blogs b) throws SQLException
	{
		String sql = "Insert into  blogs (title,contents,blog_created_date_time,user_id,category_id) values (?,?,now(),?,?)";
		try(PreparedStatement stmt = connection.prepareStatement(sql))
		{
			stmt.setString(1, b.getTitle());
			stmt.setString(2,b.getContents());
			stmt.setInt(4,b.getUser_id());
			stmt.setInt(5,b.getCategory_id());
			stmt.executeUpdate();
		}
	}
	
	
	public List<Blogs> showBlogs() throws SQLException
	{
		String sql = "Select * from blogs";
		List<Blogs> blogList = null;
		try(PreparedStatement stmt = connection.prepareStatement(sql))
		{
			ResultSet rs = stmt.executeQuery();
			blogList = new ArrayList<Blogs>();
			while(rs.next())
			{
				Blogs blogs = new Blogs();
				blogs.setTitle(rs.getString(" title"));
				blogs.setContents("contents");
				blogs.setUser_id(rs.getInt("user_id"));
				blogs.setCategory_id(rs.getInt("category_id"));
				blogList.add(blogs);
			}
		}
		return blogList;
	}
	
	public List<Blogs> myBlog(Blogs b)
	{
		String sql = "select * from blogs where user_id = ?";
		List<Blogs> blogList = null;
		try(PreparedStatement stmt = connection.prepareStatement(sql))
		{
			stmt.setInt(1,b.getUser_id());
			ResultSet rs = stmt.executeQuery();
			blogList = new ArrayList<Blogs>();
			while(rs.next())
			{
				Blogs blogs = new Blogs();
				blogs.setTitle(rs.getString(" title"));
				blogs.setContents("contents");
				
				blogs.setUser_id(rs.getInt("user_id"));
				blogs.setCategory_id(rs.getInt("category_id"));
				blogList.add(blogs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blogList;
	}
	
	
	public List<Blogs> mySearchBlog(Blogs b)
	{
		String sql = "select * from blogs where id = ?";
		List<Blogs> blogList = null;
		try(PreparedStatement stmt = connection.prepareStatement(sql))
		{
			stmt.setInt(1, b.getId());
			ResultSet rs = stmt.executeQuery();
			blogList = new ArrayList<Blogs>();
			while(rs.next())
			{
				b.setTitle(rs.getString(" title"));
				b.setContents("contents");
				
				b.setUser_id(rs.getInt("user_id"));
				b.setCategory_id(rs.getInt("category_id"));
				blogList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blogList;
	}
	
	
	public void deleteBlog(Blogs b)
	{
		String sql = "delete from blogs where id = ?";
		try(PreparedStatement stmt = connection.prepareStatement(sql))
		{
			stmt.setInt(1,b.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
