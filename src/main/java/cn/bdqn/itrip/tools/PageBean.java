package cn.bdqn.itrip.tools;

import java.util.List;

/**
 * 分页的工具类
 * @param <T> 要对哪一个实现分页
 */
public class PageBean<T> {
    //当前页 页码
    private int pageIndex;
    //每页数
    private int pageSize;
    //总页数
    private int pageCount;
    //总数
    private int totalCount;

    private List<T> list;

    public PageBean(int pageSize, int totalCount) {
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        setPageCount();
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        if (pageIndex<=0){
            this.pageIndex = 1;
        }else if (pageIndex>pageCount){
            this.pageIndex = pageCount;
        }else {
            this.pageIndex = pageIndex;
        }
    }

    public int getPageSize() {
        return pageSize;

    }

    public void setPageSize(int pageSize) {
        if (pageSize<=0){
            this.pageSize = 5;
        }else {
            this.pageSize = pageSize;
        }
        setPageCount();
    }

    public int getPageCount() {
        return pageCount;
    }
    //设置总页数
    public void setPageCount() {
        this.pageCount = totalCount%pageSize!=0?totalCount/pageSize+1:totalCount/pageSize;;
    }

    public int getTotalCount() {
        return totalCount;
    }


    public void setTotalCount(int totalCount) {

        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getStartRow(){
        return (pageIndex-1)*pageSize;
    }
}
