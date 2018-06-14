package com.yq.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao<T> {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Myshop", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//��ѯͨ�÷���
		public List<T> executQuery(String sql,Object...obj){
			//���ڴ洢rs���صĽ��
			List<T> list = new ArrayList<T>();
			try {
				//ͨ��getConnecttion��������ַ�������������һ��prepareStatement
				pst = getConnection().prepareStatement(sql);
				if(obj!=null){
					//ͨ��ѭ����ռλ����ֵ
					for(int i=0;i<obj.length;i++){
						//λ���Ǵ�1��ʼ�������ֵ���±꿪ʼ
						pst.setObject(i+1, obj[i]);
					}
				}
				//ͨ��prepareStatement�����executeQueryִ��sql����������һ�������
				rs = pst.executeQuery();
				//�ж�rs�Ƿ�����һ��ֵ
				while(rs.next()){
					//�����ֵ�������������getEntityȥ��ȡ������Ķ�����ӵ�����
					list.add(getEntity(rs));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally{
				getClose(conn, pst, rs);
			}
			return list;
		}
		
		public int Query(String sql,Object...obj){
			int num = 0;
			try {
				//ͨ��getConnecttion��������ַ�������������һ��prepareStatement
				pst = getConnection().prepareStatement(sql);
				if(obj!=null){
					//ͨ��ѭ����ռλ����ֵ
					for(int i=0;i<obj.length;i++){
						//λ���Ǵ�1��ʼ�������ֵ���±꿪ʼ
						pst.setObject(i+1, obj[i]);
					}
				}
				//ͨ��prepareStatement�����executeQueryִ��sql����������һ�������
				rs = pst.executeQuery();
				//�ж�rs�Ƿ�����һ��ֵ
				if(rs.next()){
					num = rs.getInt(1);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally{
				getClose(conn, pst, rs);
			}
			return num;
		}
		
		public boolean executUpdate(String sql,Object...obj){
			boolean flage = false;
			try {
				//ͨ��getConnecttion��������ַ�������������һ��prepareStatement
				pst = getConnection().prepareStatement(sql);
				if(obj!=null){
					//ͨ��ѭ����ռλ����ֵ
					for(int i=0;i<obj.length;i++){
						//λ���Ǵ�1��ʼ�������ֵ���±꿪ʼ
						pst.setObject(i+1, obj[i]);
					}
				}
				int num = pst.executeUpdate();
				//�ж�rs�Ƿ�����һ��ֵ
				if(num>0){
					flage= true;
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally{
				getClose(conn, pst, rs);
			}
			return flage;
		}
		
		public void getClose(Connection conn,PreparedStatement pst,ResultSet rs){
			try {
				if(rs!=null){
					rs.close();
				}
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public abstract T getEntity(ResultSet rs);
}
