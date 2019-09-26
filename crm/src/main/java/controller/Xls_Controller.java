package controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import entity.Client;
import service.ClientService;
import utils.ReturnInfo;
import utils.xls;

@Controller
@Scope(scopeName = "session")
public class Xls_Controller {
@Autowired
ClientService clientService;


List<Client> list = new ArrayList<Client>();
@RequestMapping("Xls/list")
@ResponseBody
public ReturnInfo list() {
	return new ReturnInfo(list);
}
@RequestMapping("Xls/save")
@ResponseBody
public String save(String ids) {
	for(int i=0;i<list.size();i++) {
		String id=","+list.get(i).getId()+",";
		if(ids.indexOf(id)<0)  continue;
		clientService.insert(list.get(i));
		list.get(i).setUploadstatus(1);
	}
	return "{\"status\":1}";
}
@SuppressWarnings("resource")
@RequestMapping("Xls/upload")
@ResponseBody
public String upload(@RequestParam("file") MultipartFile file) {
	list = new Vector<Client>();
	try {
		InputStream input = file.getInputStream();
		Workbook wb = new HSSFWorkbook(input);
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum() + 1;
		for (int i = 1; i < rowNum; i++) {//ѭ��ÿ��
			Client t = new Client();
			Row row = sheet.getRow(i);
			Cell names = row.getCell(0);
			String name = names.getStringCellValue();
			t.setName(name);
			Cell sexs = row.getCell(1);
			int sex = (int) sexs.getNumericCellValue();
			t.setSex(sex);
			Cell tels = row.getCell(2);
			String tel=(String) xls.getCellValue(tels);
			t.setTel(tel);
			Cell qqs = row.getCell(3);
			String qq =(String) xls.getCellValue(qqs);
			t.setQq(qq);
			Cell emails = row.getCell(4);
			String email =emails.getStringCellValue();
			t.setEmail(email);
			Cell infoss = row.getCell(5);
			String infos =infoss.getStringCellValue();
			t.setInfos(infos);
			Cell linkstatuss = row.getCell(6);
			int linkstatus =(int) linkstatuss.getNumericCellValue();
			t.setLinkstatu(linkstatus);
			Cell clienttatuss = row.getCell(7);
			int clientstatu =(int) clienttatuss.getNumericCellValue();
			t.setClientstatu(clientstatu);
			Cell purposestatu = row.getCell(8);
			int purposestatus =(int) purposestatu.getNumericCellValue();
			t.setPurposestatu(purposestatus);
			Cell assessstatuss = row.getCell(9);
			int assessstatus =(int) assessstatuss.getNumericCellValue();
			t.setAssessstatu(assessstatus);
			Cell execstatuss = row.getCell(10);
			int execstatus =(int) execstatuss.getNumericCellValue();
			t.setExecstatu(execstatus);
			Cell statuss = row.getCell(11);
			int status =(int) statuss.getNumericCellValue();
			t.setStatu(status);
			Cell clienttypeids = row.getCell(12);
			int clienttypeid =(int) clienttypeids.getNumericCellValue();
			t.setClienttypeid(clienttypeid);
			
			t.setUserids("");
			
			Cell createuserids = row.getCell(14);
			int createuserid =(int) createuserids.getNumericCellValue();
			t.setCreateuserid(createuserid);
//			Cell createdates = row.getCell(15);
//			String createdate =""+createdates.getDateCellValue();
//			String create=""+createdate;
//			t.setCreatedate(create);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			t.setCreatedate(dateStr);
			Cell srcids = row.getCell(16);
			int srcid =(int) srcids.getNumericCellValue();
			t.setSrcid(srcid);
			Cell counts = row.getCell(17);
			int count =(int) counts.getNumericCellValue();
			t.setCount(count);
			Cell commentss = row.getCell(18);
			String comments =commentss.getStringCellValue();
			t.setComments(comments);
			Cell addresss = row.getCell(19);
			String address =addresss.getStringCellValue();
			t.setAddress(address);
			
			t.setUsernames("");
			
			t.setId(i-1);
			list.add(t);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}

	return "{\"status\":1}";
}
}
