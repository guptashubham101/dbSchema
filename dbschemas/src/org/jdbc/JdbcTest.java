package org.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.shubham.dto.Student_Information;
import org.shubham.dto.Student_Marks;
import org.shubham.dto.Subject_Information;


public class JdbcTest {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	private static Object getCellValue(Cell cell,int k) {
		
		switch (cell.getCellType()) {
		
	    case Cell.CELL_TYPE_STRING:
	        return cell.getStringCellValue();
	    	
	    case Cell.CELL_TYPE_BOOLEAN:
	        return cell.getBooleanCellValue();
	 
	    case Cell.CELL_TYPE_NUMERIC:
	    if(k==0)
	    		return cell.getNumericCellValue();
	    	else
	    		return cell.getDateCellValue();
	    }
		return null;
	}

	public static void main(String[] args) 
	{
		
		String temp=null,flag=null;
		Student_Information student1 = null;
		int j=0;
		int m=0;
		//STEP 2: Register JDBC driver
		Connection conn = null;
        Statement stmt = null;
        Statement stmt1 = null;

	      
		
			try
			{	
				Class.forName("com.mysql.jdbc.Driver");
			      
			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();
			      stmt1 = conn.createStatement();
			      System.out.println("Creating statement...");
			      String sql;
			      System.out.println("Creating statement...");
			     String sqlf = "DROP TABLE student ";
			      
			      stmt.executeUpdate(sqlf);
			      
  sqlf = "DROP TABLE subject ";
			      
			      stmt.executeUpdate(sqlf);
			      
  sqlf = "DROP TABLE marks ";
			      
			      stmt.executeUpdate(sqlf);
			      System.out.println("namo");
			 /*  sql=" CREATE TYPE object2 AS OBJECT"+
			    		 "(id INTEGER not NULL, " +
			    		  "batch VARCHAR(255)," +
			    		  "dateOfBirth VARCHAR(255),"+
			    		  "enrollmentNo VARCHAR(255),"+
		                   " fathersname VARCHAR(255), " + 
		                   " mothersname VARCHAR(255), " +
		                   " name VARCHAR(255), " +
		                   " program VARCHAR(255), " +
		                   " semester VARCHAR(255), " + 
		                   " year double)";*/
		                   
			    // stmt.executeUpdate("CREATE TYPE object2 AS OBJECT(id INTEGER not NULL,batch VARCHAR(255),dateOfBirth VARCHAR(255),enrollmentNo VARCHAR(255),fathersname VARCHAR(255), mothersname VARCHAR(255),name VARCHAR(255),program VARCHAR(255),semester VARCHAR(255),year DOUBLE)");
			                   		
			                   		
			            
			      
			      sql = "CREATE TABLE student " +
		                   "(id INTEGER not NULL, " +
			    		  "batch VARCHAR(255)," +
			    		  "dateOfBirth VARCHAR(255),"+
			    		  "enrollmentNo VARCHAR(255),"+
		                   " fathersname VARCHAR(255), " + 
		                   " mothersname VARCHAR(255), " +
		                   " name VARCHAR(255), " +
		                   " program VARCHAR(255), " +
		                   " semester VARCHAR(255), " + 
		                   " year double)";
		                   // " PRIMARY KEY ( id ))"; 
			   System.out.println("namo11111");
			  // stmt.execute(sql);
			     System.out.println("namo00000000");
			   /*  sql="CREATE TABLE student " +
			    		 "(col_integer2 object2)";*/
			     
			      System.out.println("Creating statement...");
			      stmt.executeUpdate(sql);
			      System.out.println("Creating statement...");
			      sql = "CREATE TABLE subject " +
		                   "(id INTEGER not NULL, " +
			    		  "courseCode VARCHAR(255)," +
			    		  "courseTitle VARCHAR(255),"+
			    		  "credits double)";
			      //+         " PRIMARY KEY ( id ))"; 
			      stmt.executeUpdate(sql);
			      
			      sql = "CREATE TABLE marks " +
		                   "(id INTEGER not NULL, " +
			    		  "grade VARCHAR(255)," +
			    		  "totalMarks double)";
			    		 // + " PRIMARY KEY ( id ))"; 
			      stmt.executeUpdate(sql);
			      System.out.println("hello");
				FileInputStream file = new FileInputStream(new File("C:/Users/Shubham/Downloads/acadview/samples.xlsx"));
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheetAt(0);
			     System.out.println("1");
				Iterator<Row> rowIterator = sheet.iterator();
	            rowIterator.next();
	            while(rowIterator.hasNext())
	            {
	                Row row = rowIterator.next();
	                Iterator<Cell> cellIterator = row.cellIterator();
	                Student_Information student=new Student_Information();
	                Student_Marks marks=new Student_Marks();
	                Subject_Information subject=new Subject_Information();
	                cellIterator.next();
	              
	                while(cellIterator.hasNext())
	                {
	                    Cell cell = cellIterator.next();
	                    int columnIndex = cell.getColumnIndex();
	                 
	                    if((columnIndex==2))
	                    {
	                    	 String temp1=(String)getCellValue(cell,0);
	                    	 if(temp1.equals(temp))
	                    	 {
	                    		 
	                    		 j=1;
	                    	 }
	                    	 else
	                    	 {
	                    		 
	                    		 j=0;
	                    	 }
	                    }
	                    if((columnIndex==1))
	                    {
	                    	String temp2=(String)getCellValue(cell,0);
	                    	if(temp2.equals(flag))
	                    	{
	                    		
	                    	}
	                    	else
	                    	{
	                    		j=0;
	                    	}
	                    	
	               	 	}
	        
	                    switch(columnIndex) 
	                    {
	                        case 1:
	                        	if(j!=1)
	                        	 student.setName((String) getCellValue(cell,0));
	                        	 break;
	                        case 2:
	                        	if(j!=1)
	                        	student.setEnrollmentNo((String) getCellValue(cell,0));
	                            break;
	                        case 3:
	                        	if(j!=1)
	                        	student.setFatherName((String) getCellValue(cell,0));
	                            break;
	                        case 4:
	                        	if(j!=1)
	                        	student.setMotherName((String) getCellValue(cell,0));
	                            break;
	                        case 5:
	                        	if((j!=1)&&(m<12))
	                        	{
	                        		m++;
	                        		Date p=((Date) getCellValue(cell,1));
	                        		String DATE_FORMAT_NOW = "dd-MM-yyyy";
	                        		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	                        		String stringDate = sdf.format(p);
	                        		student.setDateOfBirth(stringDate); 
	                        		//student.setDateOfBirth((Double) getCellValue(cell,0));*/
	                        	}
	                        	
	                            break;
	                        case 6:
	                        	if(j!=1)
	                        	student.setProgram((String) getCellValue(cell,0));
	                            break;
	                        case 7:
	                        	if(j!=1)
	                        	student.setBatch((String) getCellValue(cell,0));
	                            break;
	                        case 8:
	                        	if(j!=1)
	                        	student.setSemester((String) getCellValue(cell,0));
	                            break;
	                        case 9:
	                        	if(j!=1)
	                        	student.setYear((Double) getCellValue(cell,0));
	                            break;
	                        case 10:
	                        	 subject.setCourseCode((String) getCellValue(cell,0));
	                            break;
	                        case 11:
	                        	subject.setCourseTitle((String) getCellValue(cell,0));
	                            break;
	                        case 12:
	                        	subject.setCredits((Double) getCellValue(cell,0));
	                            break;
	                        case 13:
	                        	marks.setTotalMarks((Double) getCellValue(cell,0));
	                            break;
	                        case 14:
	                        	marks.setGrade((String) getCellValue(cell,0));
	                            break;       
	                    }         
	                }
	                System.out.println("1");
	              Integer id=  student.getId();
	              System.out.println("1");
	            String dob=  student.getDateOfBirth();
	            		  String batch=  student.getBatch();
	            				  String enroll= student.getEnrollmentNo();
	            						  String fname= student.getFatherName();
	            								  String mname=    student.getMotherName();
	            										  String name=   student.getName();
	            												  String program=   student.getProgram();
	                String sem=  student.getSemester();
	                Double year=  student.getYear();
		    
		      String sql1;
		      System.out.println("starting");
		    /*  sql1 = "INSERT INTO student " +
	                   "VALUES (1, student.getBatch(), student.getDateOfBirth(), student.getEnrollmentNo(),student.getFatherName(),student.getMotherName(),student.getName(), student.getProgram(),student.getSemester(),student.getYear())";*/
		       sql1 = "INSERT INTO student " +
              "VALUES (id, 'dob', 'batch', 'enroll','fname','mname','name','program','sem',year)";
		      System.out.println("start");
		      stmt.executeUpdate(sql1);
	      System.out.println("ending");
	      
	       id=  subject.getId();
	      Double credits=subject.getCredits();
	      String count=subject.getCourseCode();
	      String code=subject.getCourseTitle();
	      
	      sql1 = "INSERT INTO subject " +
	              "VALUES (id, 'count', 'code', credits)";
			      System.out.println("start");
			      stmt.executeUpdate(sql1);
			      System.out.println("marks");   
			      id=marks.getId();
			      count=marks.getGrade();
			      credits=marks.getTotalMarks();
			      
			      sql1 = "INSERT INTO marks " +
			              "VALUES (id, 'count', 56)";
					      System.out.println("start");
					      System.out.println("xcvbn"); 
					      stmt.executeUpdate(sql1);
					      
		     /* sql1 = "SELECT id, name, fathersname, year FROM Student_Information";
		      ResultSet rs = stmt.executeQuery(sql1);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         String age = rs.getString("name");
		         String fathersname = rs.getString("fathersname");
		         String year = rs.getString("year");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + fathersname);
		         System.out.println(", Last: " + year);*/
		      
		      
		     
		      //STEP 6: Clean-up environment
		    //  rs1.close();
		     
		      
		   }
		   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }
			catch(Exception se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
			finally{
				try
				{
				stmt.close();
			      conn.close();
				}catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }
			}
		   
			 
	}
	}


