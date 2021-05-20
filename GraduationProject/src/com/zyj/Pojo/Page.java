package com.zyj.Pojo;

import java.util.List;

/**
 * @ClassName Page
 * @Auther: YaJun
 * @Date: 2021 - 03 - 08 - 13:06
 * @Description: com.cssve.pojo
 * @version: 1.0
 */

/**
 * Page �Ƿ�ҳ��ģ�Ͷ���
 * @param <T>   �Ǿ���� JavaBean ����
 */
public class Page<T> {

    public static final int PAGE_SIZE = 4;
    // ��ǰҳ��
    private Integer pageNo;
    // ��ҳ��
    private Integer pageTotal;
    // ��ǰҳ��ʾ������ҳ��С��
    private Integer pageSize = PAGE_SIZE;
    // �ܼ�¼��
    private Integer pageTotalCount;
    // ��ǰҳ����
    private List<T> items;
    // ��ҳ���������ַ
    private String url;
    // ��ʼ�±�
    private int startIndex;
    // �����±�
    private int endIndex;
    // ��һҳ
    private int prePage;
    // ��һҳ
    private int nextPage;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        // �߽���
        if (pageNo < 1) {
            pageNo = 1;
        } else if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public Page() {

    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize, Integer pageTotalCount, List<T> items) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageTotalCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        int pageTotal = pageTotalCount / pageSize;
        this.pageTotal = pageTotalCount % pageSize == 0 ? pageTotal : pageTotal + 1;
        prePage = pageNo > 1 ? pageNo - 1 : pageNo;
        nextPage = pageNo < pageTotal ? pageNo + 1 : pageTotal;
        startIndex = pageNo > 0 ? (pageNo -1) * pageSize : 0;
        endIndex = pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
