package com.ledao.util;

/**
 * 分页工具类
 *
 * @author LeDao
 * @company
 * @create 2020-01-28 00:27
 */
public class PageUtil {

    /**
     * 生成分页代码(商品按类别展示时使用)
     *
     * @param targetUrl   目标地址
     * @param totalNum    总记录数
     * @param currentPage 当前页
     * @param pageSize    每页大小
     * @param typeId      商品类别
     * @return
     */
    public static String genPagination(String targetUrl, long totalNum, int currentPage, int pageSize, int typeId) {
        //当前页前后页的显示数量
        int pageTotal = 2;
        long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        if (totalPage == 0) {
            return "未查询到数据";
        } else {
            StringBuffer pageCode = new StringBuffer();
            pageCode.append("<li class='page-item'><a href='" + targetUrl + "/1?typeId=" + typeId + "' class='page-link'>首页</a></li>");
            if (currentPage > 1) {
                pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + (currentPage - 1) + "?typeId=" + typeId + "' class='page-link'><span aria-hidden='true'>«</span><span class='sr-only'>Previous</span></a></li>");
            } else {
                pageCode.append("<li class='disabled page-item'><a href='#' class='page-link'><span aria-hidden='true'>«</span><span class='sr-only'>Previous</span></a></li>");
            }
            for (int i = currentPage - pageTotal; i <= currentPage + pageTotal; i++) {
                if (i < 1 || i > totalPage) {
                    continue;
                }
                if (i == currentPage) {
                    pageCode.append("<li class='page-item active'><a href='" + targetUrl + "/" + i + "?typeId=" + typeId + "' class='page-link'>" + i + "</a></li>");
                } else {
                    pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + i + "?typeId=" + typeId + "' class='page-link'>" + i + "</a></li>");
                }
            }
            if (currentPage < totalPage) {
                pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + (currentPage + 1) + "?typeId=" + typeId + "'  aria-label='Next' class='page-link'><span aria-hidden='true'>»</span><span class='sr-only'>Next</span></a></li>");
            } else {
                pageCode.append("<li class='disabled page-item'><a href='#' aria-label='Next' class='page-link'><span aria-hidden='true'>»</span><span class='sr-only'>Next</span></a></li>");
            }
            pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + totalPage + "?typeId=" + typeId + "' aria-label='Next' class='page-link'>尾页</a></li>");
            return pageCode.toString();
        }
    }

    /**
     * 生成分页代码
     *
     * @param targetUrl   目标地址
     * @param totalNum    总记录数
     * @param currentPage 当前页
     * @param pageSize    每页大小
     * @return
     */
    public static String genPagination2(String targetUrl, long totalNum, int currentPage, int pageSize) {
        //当前页前后页的显示数量
        int pageTotal = 2;
        long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        if (totalPage == 0) {
            return "未查询到数据";
        } else {
            StringBuffer pageCode = new StringBuffer();
            pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + "1" + "' class='page-link'>首页</a></li>");
            if (currentPage > 1) {
                pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + (currentPage - 1) + "' class='page-link'><span aria-hidden='true'>«</span><span class='sr-only'>Previous</span></a></li>");
            } else {
                pageCode.append("<li class='disabled page-item'><a href='#' class='page-link'><span aria-hidden='true'>«</span><span class='sr-only'>Previous</span></a></li>");
            }
            for (int i = currentPage - pageTotal; i <= currentPage + pageTotal; i++) {
                if (i < 1 || i > totalPage) {
                    continue;
                }
                if (i == currentPage) {
                    pageCode.append("<li class='page-item active'><a href='" + targetUrl + "/" + i + "' class='page-link'>" + i + "</a></li>");
                } else {
                    pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + i + "' class='page-link'>" + i + "</a></li>");
                }
            }
            if (currentPage < totalPage) {
                pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + (currentPage + 1) + "'  aria-label='Next' class='page-link'><span aria-hidden='true'>»</span><span class='sr-only'>Next</span></a></li>");
            } else {
                pageCode.append("<li class='disabled page-item'><a href='#' aria-label='Next' class='page-link'><span aria-hidden='true'>»</span><span class='sr-only'>Next</span></a></li>");
            }
            pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + totalPage + "' aria-label='Next' class='page-link'>尾页</a></li>");
            return pageCode.toString();
        }
    }

    /**
     * 生成分页代码(查看评价专用)
     *
     * @param targetUrl
     * @param totalNum
     * @param currentPage
     * @param pageSize
     * @param goodsId
     * @return
     */
    public static String genPagination3(String targetUrl, long totalNum, int currentPage, int pageSize, int goodsId) {
        //当前页前后页的显示数量
        int pageTotal = 2;
        long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        if (totalPage == 0) {
            return "未查询到数据";
        } else {
            StringBuffer pageCode = new StringBuffer();
            pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + "1?goodsId=" + goodsId + "' class='page-link'>首页</a></li>");
            if (currentPage > 1) {
                pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + (currentPage - 1) + "?goodsId=" + goodsId + "' class='page-link'><span aria-hidden='true'>«</span><span class='sr-only'>Previous</span></a></li>");
            } else {
                pageCode.append("<li class='disabled page-item'><a href='#' class='page-link'><span aria-hidden='true'>«</span><span class='sr-only'>Previous</span></a></li>");
            }
            for (int i = currentPage - pageTotal; i <= currentPage + pageTotal; i++) {
                if (i < 1 || i > totalPage) {
                    continue;
                }
                if (i == currentPage) {
                    pageCode.append("<li class='page-item active'><a href='" + targetUrl + "/" + i + "?goodsId=" + goodsId + "' class='page-link'>" + i + "</a></li>");
                } else {
                    pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + i + "?goodsId=" + goodsId + "' class='page-link'>" + i + "</a></li>");
                }
            }
            if (currentPage < totalPage) {
                pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + (currentPage + 1) + "?goodsId=" + goodsId + "'  aria-label='Next' class='page-link'><span aria-hidden='true'>»</span><span class='sr-only'>Next</span></a></li>");
            } else {
                pageCode.append("<li class='disabled page-item'><a href='#' aria-label='Next' class='page-link'><span aria-hidden='true'>»</span><span class='sr-only'>Next</span></a></li>");
            }
            pageCode.append("<li class='page-item'><a href='" + targetUrl + "/" + totalPage + "?goodsId=" + goodsId + "' aria-label='Next' class='page-link'>尾页</a></li>");
            return pageCode.toString();
        }
    }
}
