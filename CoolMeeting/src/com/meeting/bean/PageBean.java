package com.meeting.bean;
/**
 * @see 分页类，用于封装分页时用的属性
 * @author 刘均前
 * @since 2015-08-29
 * @version V1.0
 */
public class PageBean {
	public static int ROWS_PRO_PAGE = 4;
	private int pageno;
	private int maxpage;

	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		this.pageno = pageno;
	}

	public int getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}

}
