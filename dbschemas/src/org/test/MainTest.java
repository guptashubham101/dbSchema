package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.shubham.dto.Student_Information;
import org.shubham.dto.Student_Marks;
import org.shubham.dto.Subject_Information;


public class MainTest {
	private static Object getCellValue(Cell cell,int j) {
		
		switch (cell.getCellType()) {
	    case Cell.CELL_TYPE_STRING:
	    	if(j==0)
	        return cell.getStringCellValue();
	    	else
	    		return cell.getDateCellValue();	
	    case Cell.CELL_TYPE_BOOLEAN:
	        return cell.getBooleanCellValue();
	 
	    case Cell.CELL_TYPE_NUMERIC:
	        return cell.getNumericCellValue();

	    }
return null;		
	}
	public static void main(String[] args) {
	String temp=null;
	Student_Information student1 = null;
	int j=0;
		try
		{
			FileInputStream file = new FileInputStream(new File("C:/Users/Shubham/Downloads/sample.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while(rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                Student_Information student=new Student_Information();
                Student_Marks marks=new Student_Marks();
                Subject_Information subject=new Subject_Information();
                cellIterator.next();
              
                while(cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                  //  System.out.println(columnIndex);
                   
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
                        	if(j!=1)
                        	student.setDateOfBirth((Double) getCellValue(cell,1));
                        	
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
                SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
        	    
        		Session session=sessionfactory.openSession();
        		session.beginTransaction();
                if(j==0)
                {
                	student1=student;
                	student1.getSubjects().add(subject);
                	session.save(student1);
                }     
                subject.setStudentInformation(student1);
               // temp=student1.getEnrollmentNo();
              //  System.out.println(temp);
               /* student.getMarks().add(marks);
                marks.setStudentInformation(student);
              
                subject.setStudentmarks(marks);*/
               
                
        		
                session.save(marks);
                session.save(subject);
                
            	session.getTransaction().commit();
        		session.close();
            }
            workbook.close();
            file.close();
        
        
        
        
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	}
}
