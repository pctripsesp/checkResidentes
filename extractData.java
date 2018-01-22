package extractExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * This program illustrates how to read a password-protected Excel document
 * in 2003 format - XLS
 * thanks to www.codejava.net examples and stackoverflow community
 * @author pctripsesp
 */

public class extractData {
	
	private static String rutaArchivo = System.getProperty("user.home")+"/_PATH_.xls";		//CHANGE PATH
    
	public static ArrayList<String[]> getterData(ArrayDatos arrayDatos) throws IOException {
 	
        String excelFilePath = rutaArchivo;
        
        //CARGAMOS ARCHIVO Y COMPROBAMOS SI EXISTE
        File f = new File(excelFilePath);  
        
        if (f.exists()) {
        	
        	//f.setReadOnly();
        	FileInputStream fis = new FileInputStream(f);  			
                  
            Biff8EncryptionKey.setCurrentUserPassword("_PASS_");		//CHANGE PASSWORD
            Workbook workbook = new HSSFWorkbook(fis);
             
            Sheet firstSheet = workbook.getSheetAt(0);
            
            /** NUM TOTAL DE FILAS EN EL EXCEL
            int numTotalFilas = firstSheet.getPhysicalNumberOfRows();
            System.out.println(numTotalFilas);
            **/
            
            Iterator<Row> iterator = firstSheet.iterator();
            //Creamos la lista para almacenar los datos
            ArrayList<String[]> listaDatos = new ArrayList<String[]>();
            
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                
                //CREAMOS ARRAY PARA CADA FILA PARA ALMACENAR LOS MATCHES              		
        		String[] fila = new String[6];	//NUM CELLS per ROW
        		
        		boolean flag_coincide = false;
        		for (int numCelda=0; numCelda<6; numCelda++ ){
        			    			
    				Cell cell = nextRow.getCell(numCelda);
    				//COMPROBAMOS QUE LA CELDA NO ESTE VACIA
    				if (cell == null || cell.getCellTypeEnum() == CellType.BLANK) {
    					fila[numCelda] = "";
    					
    				 }else{
    					
	    				switch (cell.getCellTypeEnum()) {
	    				
	                	//EN CASO DE QUE SEA STRING, LO COMPARAMOS	    				
		                	case STRING:
		                		//String valorCelda = cell.getStringCellValue();
		                		String valorCelda = darFormato(cell.getStringCellValue()); 
		                		
			                		
		                		//VEMOS COINCIDENCIA DE LA BUSQUEDA CON EL ELEMENTO CORRESPONDIENTE
		                		switch (numCelda) {
									case 0:
										if ((! arrayDatos.pabellon.isEmpty()) && (valorCelda.contains(darFormato(arrayDatos.pabellon)))){	
											flag_coincide = true;
											
										}											
										break;
										
									case 1:
										if ((! arrayDatos.nombre.isEmpty()) && (valorCelda.contains(darFormato(arrayDatos.nombre)))){	
											flag_coincide = true;	
											
										}											
										break;
										
									case 2:
										if ((! arrayDatos.dni.isEmpty()) && (valorCelda.contains(darFormato(arrayDatos.dni)))){	
											flag_coincide = true;	
											
										}											
										break;
										
									case 3:
										if ((! arrayDatos.telefono.isEmpty()) && (valorCelda.contains(darFormato(arrayDatos.telefono)))){	
											flag_coincide = true;	
											
										}											
										break;
										
									case 4:
										if ((! arrayDatos.vehiculo.isEmpty()) && (valorCelda.contains(darFormato(arrayDatos.vehiculo)))){	
											flag_coincide = true;	
											
										}											
										break;
										
									case 5:
										if ((! arrayDatos.observaciones.isEmpty()) && (valorCelda.contains(darFormato(arrayDatos.observaciones)))){	
											flag_coincide = true;
											
										}											
										break;
		
									default:
										break;
								}
		                		fila[numCelda] = valorCelda;
		                		   
		                        break;
		                		
		                    //SI ES NUMERICO, TENEMOS QUE PASARLO A STRING PARA COMPARARLO
		                    case NUMERIC:
		                    	String valCelda = darFormato(String.valueOf(Math.round(cell.getNumericCellValue())));
		                    	switch (numCelda) {
									case 0:
										System.out.println((arrayDatos.pabellon != ""));
										if ((! arrayDatos.pabellon.isEmpty()) && (valCelda.contains(darFormato(arrayDatos.pabellon)))){	
											flag_coincide = true;											
										}											
										break;
										
									case 1:
										if ((! arrayDatos.nombre.isEmpty()) && (valCelda.contains(darFormato(arrayDatos.nombre)))){	
											flag_coincide = true;											
										}											
										break;
										
									case 2:
										if ((! arrayDatos.dni.isEmpty()) && (valCelda.contains(darFormato(arrayDatos.dni)))){	
											flag_coincide = true;											
										}											
										break;
										
									case 3:
										if ((! arrayDatos.telefono.isEmpty()) && (valCelda.contains(darFormato(arrayDatos.telefono)))){	
											flag_coincide = true;											
										}											
										break;
										
									case 4:
										if ((! arrayDatos.vehiculo.isEmpty()) && (valCelda.contains(darFormato(arrayDatos.vehiculo)))){	
											flag_coincide = true;											
										}											
										break;
										
									case 5:
										if ((! arrayDatos.observaciones.isEmpty()) && (valCelda.contains(darFormato(arrayDatos.observaciones)))){	
											flag_coincide = true;											
										}											
										break;
	
								default:
									break;
							}    
		                    	fila[numCelda] = valCelda; 
		                        break;
		                     
		
							default:					
								break;
	    					
		    				}	      				        				                
	    					
	                    }
	                    
        		}
                          
            //AÑADIMOS EL ARRAY DE LA FILA A LA LISTA
        	if (flag_coincide){        		
        		listaDatos.add(fila);
        	}
            
         }
          
         workbook.close();
         fis.close();
         //System.out.println(listaDatos);
         return listaDatos;
         
         
     } else {
         System.out.println("File does not exists.");
         return null;
     }
		
     
     
 }
        		
 
	
	
	
	//HACEMOS UNA FUNCION PARA PONER TODO EN MAYUSCULAS SIN TILDES DEL EXCEL
	public static String darFormato(String celda){
		
		String sinGuion = 	celda.replace("-","");
		String sinAcentos = StringUtils.stripAccents(sinGuion);
		String celdaFormateada = sinAcentos.toUpperCase();
			
		return celdaFormateada;
	}
	
	
	
	
	
}
