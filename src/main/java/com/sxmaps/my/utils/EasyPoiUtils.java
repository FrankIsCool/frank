package com.sxmaps.mms.utils;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;

/**
 * 文件导入导出工具类
 * 
 * @author chendehua
 *
 */
@Component
public class EasyPoiUtils {

	private EasyPoiUtils() {
	}

	private final static EasyPoiUtils inStance = new EasyPoiUtils();

	public static EasyPoiUtils getStance() {
		return inStance;
	}

	/**
	 * 导出excel
	 * 
	 * @param list
	 * @param title
	 * @param sheetName
	 * @param pojoClass
	 * @param fileName
	 * @param isCreateHeader
	 * @param response
	 * @throws Exception
	 */
	public void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName,
			boolean isCreateHeader, HttpServletResponse response) throws Exception {
		ExportParams exportParams = new ExportParams(title, sheetName);
		exportParams.setCreateHeadRows(isCreateHeader);
		defaultExport(list, pojoClass, fileName, response, exportParams);

	}

	/**
	 * 导出excel
	 * 
	 * @param list
	 * @param title
	 * @param sheetName
	 * @param pojoClass
	 * @param fileName
	 * @param response
	 * @throws Exception
	 */
	public void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName,
			HttpServletResponse response) throws Exception {
		defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
	}

	/**
	 * 导出excel
	 * 
	 * @param list
	 * @param fileName
	 * @param response
	 * @throws Exception
	 */
	public void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response)
			throws Exception {
		defaultExport(list, fileName, response);
	}

	/**
	 * 文件导出
	 * 
	 * @param list
	 * @param pojoClass
	 * @param fileName
	 * @param response
	 * @param exportParams
	 * @throws Exception
	 */
	private void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response,
			ExportParams exportParams) throws Exception {
		Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
		if (workbook != null)
			downLoadExcel(fileName, response, workbook);
	}

	/**
	 * 文件下载
	 * 
	 * @param fileName
	 * @param response
	 * @param workbook
	 * @throws Exception
	 */
	private void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-Type", "application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
		response.flushBuffer();
		workbook.write(response.getOutputStream());
		response.getOutputStream().close();
	}

	/**
	 * 文件导出
	 * 
	 * @param list
	 * @param fileName
	 * @param response
	 * @throws Exception
	 */
	private void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response)
			throws Exception {
		Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
		if (workbook != null)
			downLoadExcel(fileName, response, workbook);
	}

	/**
	 * 文件导入
	 * 
	 * @param filePath
	 * @param titleRows
	 * @param headerRows
	 * @param pojoClass
	 * @return
	 */
	public <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
		if (StringUtils.isBlank(filePath)) {
			return null;
		}
		ImportParams params = new ImportParams();
		params.setTitleRows(titleRows);
		params.setHeadRows(headerRows);
		List<T> list = null;
		list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
		return list;
	}

	/**
	 * 文件导入
	 * 
	 * @param file
	 * @param titleRows
	 * @param headerRows
	 * @param pojoClass
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)
			throws Exception {
		if (file == null) {
			return null;
		}
		ImportParams params = new ImportParams();
		params.setTitleRows(titleRows);
		params.setHeadRows(headerRows);
		List<T> list = null;
		list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
		return list;
	}

}
