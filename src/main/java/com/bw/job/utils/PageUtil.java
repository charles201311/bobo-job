package com.bw.job.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


/**
 * 分页工具类
 *  
 */
public final class PageUtil {
	
	
	
	/**
	 * 分页面显示
	 * @param request 
	 * @param url      请求的mapping路径
	 * @param pageSize 每页显示的数据条数
	 * @param list     显示的list集合
	 * @param listCount 一共有多少条数据
	 * @param page     当前页码
	 */
	public static void page(HttpServletRequest request, String url, Integer pageSize, List<?> list, Integer listCount, Integer page) {
		// 通过符合要求的总条数和页面显示数来计算总页数
		int pageCount = listCount/pageSize + (listCount%pageSize == 0 ? 0 : 1);
		//System.out.println("pageCount=="+pageCount);
		// 判断url上是否有?号，如果有，后面通过&符号进行连接，否则通过?进行连接
		String flag = url.indexOf("?") != -1 ? "&" : "?";
		
		
		
		// 分页的首页、上一页、下一页、末页
		String first = "";
		String prev ="";
		String next = "";
		String last = "";
		
		if(page != 1) {
			first = "<a href='"+request.getContextPath()+url+flag+"page=1'>首页</a>";
		} else {
			first = "首页";
		}
		
		if(page > 1) {
			prev = "<a href='"+request.getContextPath()+url+flag+"page="+(page-1)+"'>上一页</a>";
		} else {
			prev = "上一页";
		}
		
		if(page < pageCount) {
			next = "<a href='"+request.getContextPath()+url+flag+"page="+(page + 1)+"'>下一页</a>";
		} else {
			next = "下一页";
		}
		
		if(page != pageCount) {
			last = "<a href='"+request.getContextPath()+url+flag+"page="+pageCount+"'>末页</a>";
		} else {
			last = "末页";
		}
		request.setAttribute("page", "共有"+listCount+"条数据"+" 当前为第"+page+"页 &nbsp;"+first+" "+prev+" "+next+" "+last);
	}
	
}
