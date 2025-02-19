package com.woojin.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woojin.app.util.DBConnection;

@Repository
public class ProductDAO {
	@Autowired
	private ProductDTO productDTO;

	public List<ProductDTO> getList() throws Exception {
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS ORDER BY PRODUCTNUM ASC";
		PreparedStatement ps = conn.prepareStatement(sql);
		List<ProductDTO> ar = new ArrayList<ProductDTO>();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("productNum"));
			productDTO.setProductName(rs.getString("productName"));
			productDTO.setProductRate(rs.getDouble("productRate"));
			productDTO.setProductDetail(rs.getString("productDetail"));
			productDTO.setProductDate(rs.getDate("productDate"));
			ar.add(productDTO);
		}
		DBConnection.disConnection(rs, ps, conn);
		
		return ar;
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		int result = 0;
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCTS (PRODUCTNUM, PRODUCTNAME, PRODUCTRATE, PRODUCTDETAIL, PRODUCTDATE)"
				+" VALUES (PRODUCTNUM_SEQ.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, productDTO.getProductName());
		ps.setDouble(2, productDTO.getProductRate());
		ps.setString(3, productDTO.getProductDetail());
		ps.setDate(4, productDTO.getProductDate());
		
		result = ps.executeUpdate();
		
		DBConnection.disConnection(ps, conn);
		
		return result;
	}
	
	public ProductDTO detail(ProductDTO productDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTNUM=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setLong(1, productDTO.getProductNum());
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			productDTO.setProductNum(rs.getLong("productNum"));
			productDTO.setProductName(rs.getString("productName"));
			productDTO.setProductRate(rs.getDouble("productRate"));
			productDTO.setProductDetail(rs.getString("productDetail"));
			productDTO.setProductDate(rs.getDate("productDate"));
		}
		
		DBConnection.disConnection(rs, ps, conn);
		
		return productDTO;
	}
	
	
}
