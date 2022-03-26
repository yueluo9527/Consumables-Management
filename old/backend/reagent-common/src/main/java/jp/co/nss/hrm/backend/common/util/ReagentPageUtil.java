package jp.co.nss.hrm.backend.common.util;

import java.util.List;

public class ReagentPageUtil {
    /**
     * 开始分页
     *
     * @param list
     * @param pageNum  页码
     * @param pageSize 每页多少条数据
     * @return
     */
    public static List startPage(List list, Integer pageNum, Integer pageSize) {
        if (list == null) {
            return null;
        }
        if (list.size() == 0) {
            return null;
        }

        Integer count = list.size(); // 记录总数
        int pageCount = 0; // 页数
        if (count % pageSize == 0) {
            pageCount = count / pageSize;
        } else {
            pageCount = count / pageSize + 1;
        }
        System.out.println("count: " + count);
        System.out.println("pageCount: " + pageCount);

        int fromIndex = 0; // 开始索引
        int toIndex = 0; // 结束索引

        if (!pageNum.equals(pageCount)) {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = fromIndex + pageSize;
            System.out.println("多页");
        } else {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = count;
            System.out.println("一页");
        }
        System.out.println("Index1: " + fromIndex + ", Index2: " + toIndex);

        List pageList = list.subList(fromIndex, toIndex);

        return pageList;
    }
}
