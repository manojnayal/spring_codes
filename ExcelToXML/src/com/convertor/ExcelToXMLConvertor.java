package com.convertor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ExcelToXMLConvertor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelToXMLConvertor poiExample = new ExcelToXMLConvertor ();
		System.out.println("in here");
	    String xlsPath ="Book.xlsx";
	    poiExample.displayFromExcel (xlsPath);
	}

	private void displayFromExcel(String xlsPath) {
		InputStream inputStream = null; 
	    try
	    {
	        inputStream = new FileInputStream (xlsPath);
	    }
	    catch (FileNotFoundException e)
	    {
	        System.out.println ("File not found in the specified path.");
	        e.printStackTrace ();
	    }
	    try {
	    	XSSFWorkbook wb = new XSSFWorkbook(inputStream);
	    	
	        XSSFSheet sheet    = wb.getSheetAt(0); 
	        Iterator<?> rows     = sheet.rowIterator();

	        ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
	        while(rows.hasNext()) {
	        	XSSFRow row = (XSSFRow) rows.next(); 

	            int rowNumber = row.getRowNum ();
	            if(row.getRowNum()==0){
	            	   continue; //just skip the rows if row number is 0 or 1
	            }
	            // display row number
	            System.out.println ("Row No.: " + rowNumber);

	            // get a row, iterate through cells.
	            Iterator<?> cells = row.cellIterator (); 

	            HashMap<String,String> rowData = new HashMap<String,String>();
	            while (cells.hasNext ())
	            {
	                XSSFCell cell = (XSSFCell) cells.next ();
	                //System.out.println ("Cell : " + cell.getCellNum ());
	                
	                
	                switch (String.valueOf(cell.getColumnIndex()))
	                {
	                case "0" :
	                {
	                	if(cell.getCellType()== XSSFCell.CELL_TYPE_NUMERIC) {
	                		System.out.print(cell.getNumericCellValue() + "\t\t");
	                        rowData.put("code",(int)cell.getNumericCellValue() + "");
	                	}else {
	                		XSSFRichTextString richTextString = cell.getRichStringCellValue ();
	                		rowData.put("code",richTextString.getString());
	                	}
	                    
	                    break;
	                }
	                case "1" :
	                {
	                	XSSFRichTextString richTextString = cell.getRichStringCellValue ();
	                	 rowData.put("description",richTextString.getString());
	                	 break;
	                }
	                case "2" :
	                {
	                	XSSFRichTextString richTextString = cell.getRichStringCellValue ();
	                	rowData.put("value",richTextString.getString());
	                	break;
	                }
	                case "3" :
	                {
	                	 SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	                        System.out.print(dateFormat.format(cell.getDateCellValue()) + "\t\t");
	                        rowData.put("startDate",dateFormat.format(cell.getDateCellValue())+"");
	                        break;
	                }
	                
	                default:
	                {
	                    // types other than String and Numeric.
	                    System.out.println ("Type not supported.");
	                    break;
	                }
	                } // end switch

	            } // end while
	            if(rowData.isEmpty()) {
	            	continue;
	            }
	            System.out.println(rowData);
	            data.add(rowData);
	            
	        }
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document document = builder.newDocument();
	        Element rootElement = document.createElement("v3:procedures");
	        rootElement.setAttribute("xmlns:v3", "http://healthinsurance.oracle.com/procedures/v3");
	        document.appendChild(rootElement);
	        Element header = document.createElement("v3:header");
	        header.setAttribute("flexCodeDefinitionCode","CPT_CODES");
	        rootElement.appendChild(header);
	        for (int i = 0; i < data.size(); i++) {
	        	Element procedureElement = document.createElement("v3:procedure");
	            rootElement.appendChild(procedureElement);
	            HashMap<String,String> map=data.get(i);
	            procedureElement.setAttribute("elementId", "ID_"+i);
	            procedureElement.setAttribute("code", map.get("code"));
	            procedureElement.setAttribute("description", map.get("description").length()>90?
	            		map.get("description").substring(0, 90):map.get("description"));
	            procedureElement.setAttribute("startDate", map.get("startDate"));
	            procedureElement.setAttribute("endDate", "");
	            procedureElement.setAttribute("gender", "");
	            Element dynamicFields = document.createElement("dat:dynamicFields");
	            dynamicFields.setAttribute("xmlns:dat", "http://healthinsurance.oracle.com/datatypes");
	            procedureElement.appendChild(dynamicFields);
	            Element dynamicField = document.createElement("dat:dynamicField");
	            dynamicField.setAttribute("name", "UDP_PROC_TYP_DSC_LONG");
	            dynamicFields.appendChild(dynamicField);
	            Text datValue = document.createTextNode("dat:value");
		        datValue.setData( map.get("value").length()>90?
	            		map.get("value").substring(0, 90):map.get("value"));
		        procedureElement.appendChild(datValue);
	            
			}
	        TransformerFactory tFactory = TransformerFactory.newInstance();

	        Transformer transformer = tFactory.newTransformer();
	        //Add indentation to output
	        transformer.setOutputProperty
	        (OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty(
	                "{http://xml.apache.org/xslt}indent-amount", "2");

	        DOMSource source = new DOMSource(document);
	        StreamResult result = new StreamResult(new File("products.xml"));
	        //StreamResult result = new StreamResult(System.out);
	        transformer.transform(source, result);
	        
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
	}

}
