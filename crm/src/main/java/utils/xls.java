package utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;

public class xls {
	 public static Object getCellValue(Cell cell) {
	        Object value = null;
	        DecimalFormat df = new DecimalFormat("0"); // ��ʽ��number String�ַ�
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // ���ڸ�ʽ��
	        DecimalFormat df2 = new DecimalFormat("0"); // ��ʽ������

	        switch (cell.getCellType()) {
	        case STRING:
	            value = cell.getRichStringCellValue().getString();
	            break;
	        case NUMERIC:
	            if ("General".equals(cell.getCellStyle().getDataFormatString())) {
	                value = df.format(cell.getNumericCellValue());
	            } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
	                value = sdf.format(cell.getDateCellValue());
	            } else {
	                value = df2.format(cell.getNumericCellValue());
	            }
	            break;
	        case BOOLEAN:
	            value = cell.getBooleanCellValue();
	            break;
	        case BLANK:
	            value = "";
	            break;
	        default:
	            break;
	        }
	        return value;
	    }
}
