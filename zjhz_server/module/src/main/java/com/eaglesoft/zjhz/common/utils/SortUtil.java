package com.eaglesoft.zjhz.common.utils;

import com.eaglesoft.zjhz.common.xss.SQLFilter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eaglesoft.zjhz.common.page.OrderByVo;
import com.eaglesoft.zjhz.common.page.QueryRequest;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 处理排序工具类
 */
@SuppressWarnings("unchecked")
public class SortUtil {

    /**
     * 处理排序（分页情况下） for mybatis-plus
     *
     * @param request,          QueryRequest
     * @param page              Page
     * @param defaultSort       默认排序的字段
     * @param defaultOrder      默认排序规则
     * @param camelToUnderscore 是否开启驼峰转下划线
     */
    public static void handlePageSort(QueryRequest request, Page page, String defaultSort, String defaultOrder, boolean camelToUnderscore) {
        page.setCurrent(request.getPageIndex());
        page.setSize(request.getPageSize());

        List<OrderByVo> orders = request.getOrders();
        if (orders != null && orders.size() > 0) {
            StringBuilder sortInfo = new StringBuilder();
            for (int i = orders.size() - 1; i >= 0; i--) {
                String order = orders.get(i).getId();
                if (camelToUnderscore) {
                    order = UiasUtil.camelToUnderscore(order);
                }
                String sort = orders.get(i).getType();
                if (!SQLFilter.sqlValidate(order)) {
                    sortInfo.append(order).append(" ").append(sort.toLowerCase()).append(", ");
                }
            }
            String sql = sortInfo.toString().trim();
            page.setAsc(sql.substring(0, sql.length() - 1));

        } else {
            if (camelToUnderscore) {
                defaultSort = UiasUtil.camelToUnderscore(defaultSort);
            }
            if (StringUtils.isNotBlank(defaultSort) && StringUtils.isNotBlank(defaultOrder)) {
                page.setAsc(defaultSort + " " + defaultOrder);
            }
        }

        /*String orderBy = request.getOrderBy();
        String sortType = request.getSortType();
        if (camelToUnderscore) {
            orderBy = UiasUtil.camelToUnderscore(orderBy);
            defaultSort = UiasUtil.camelToUnderscore(defaultSort);
        }

        if (StringUtils.isNotBlank(orderBy) && StringUtils.isNotBlank(sortType)
                && !StringUtils.equalsIgnoreCase(orderBy, "undefined")
                && !StringUtils.equalsIgnoreCase(sortType, "undefined")) {


            String[] orderBys = orderBy.split(",");
            String[] sortTypes = sortType.split(",");

            StringBuilder sortInfo = new StringBuilder();
            for (int i = 0; i < orderBys.length; i++) {
                if (!SQLFilter.sqlValidate(orderBys[i])) {
                    sortInfo.append(orderBys[i]).append(" ").append(sortTypes[i].toLowerCase()).append(", ");
                }
            }
            String sql = sortInfo.toString().trim();
            page.setAsc(sql.substring(0, sql.length() - 1));
        } else {
            if (StringUtils.isNotBlank(defaultSort) && StringUtils.isNotBlank(defaultOrder)) {
                page.setAsc(defaultSort + " " + defaultOrder);
            }
        }*/

    }

}
