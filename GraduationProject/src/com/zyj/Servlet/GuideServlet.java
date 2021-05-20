package com.zyj.Servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyj.Pojo.*;
import com.zyj.Service.GuideService;
import com.zyj.Service.Impl.GuideServiceImpl;
import com.zyj.Utils.BackLayUIInfo;
import com.zyj.bean.LayUIResponse;
import com.zyj.converters.ConvertBean;
import com.zyj.https.BaseServlet;
import com.zyj.https.WebUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName ${NAME}
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 15:22
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet("/guide")
public class GuideServlet extends BaseServlet {

    GuideService guideService = new GuideServiceImpl();
    JSONObject jsonObject = new JSONObject();

    private void getDeleteInfo(HttpServletResponse response, boolean flag) throws IOException {
        if (flag) {
            jsonObject.put("success", true);
            jsonObject.put("message", "Delete Success");
        } else {
            jsonObject.put("success", false);
            jsonObject.put("message", "Delete Fail");
        }
        response.getWriter().write(jsonObject.toString());
    }

    private void getEditRespInfo(HttpServletResponse response, boolean flag) throws IOException {
        if (flag) {
            jsonObject.put("success", true);
            jsonObject.put("message", "Edit Success");
        } else {
            jsonObject.put("success", false);
            jsonObject.put("message", "Edit Fail");
        }
        response.getWriter().write(jsonObject.toString());
    }

    private void getBatchDeleteInfo(HttpServletResponse response, boolean flag) throws IOException {
        JSONObject jsonObject = new JSONObject();
        if (flag) {
            jsonObject.put("success", true);
            jsonObject.put("message", "BatchDelete Success");
        } else {
            jsonObject.put("success", false);
            jsonObject.put("message", "BatchDelete Fail");
        }
        response.getWriter().write(jsonObject.toString());
    }


    /**
     * 查询所有城市
     *
     * @param request
     * @param response
     */
    protected void queryAllCities(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 调用业务层查询所有城市
            List<City> cities = guideService.queryAllCity();
            // 传递给浏览器
            String jsonString = JSON.toJSONString(cities);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除防护问题
     *
     * @param request
     * @param response
     */
    protected void deletePp_probByPp_id(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取 rid
            int problem_id = WebUtils.parseInt(request.getParameter("problem_id"), 0);
            // 调用业务层删除该条谣言信息
            boolean flag = guideService.deletePp_probByPp_id(problem_id);
            getDeleteInfo(response, flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改防护问题
     *
     * @param request
     * @param response
     */
    protected void editPP_Prob(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取表单参数，封装为谣言对象
            Protection_Problem pp_prob = ConvertBean.toBeans(Protection_Problem.class, request.getParameterMap());
            // 调用业务层实现添加
            boolean flag = guideService.editPp_prob(pp_prob);
            // 通过响应传输给客户端
            getEditRespInfo(response, flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量删除防护问题
     *
     * @param request
     * @param response
     */
    protected void batchDeletePP_Prob(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取 id 字符串
            String ids = request.getParameter("ids");
            // 调用业务层方法删除所有选中的数据
            boolean flag = guideService.batchDeletePP_Prob(ids);
            getBatchDeleteInfo(response, flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加防护问题
     *
     * @param request
     * @param response
     */
    protected void addPP_Prob(HttpServletRequest request, HttpServletResponse response) {
        // 获取表单参数，封装为谣言对象
        Protection_Problem pp_Prob = ConvertBean.toBeans(Protection_Problem.class, request.getParameterMap());
        // 调用业务层实现添加
        boolean flag = guideService.savePp_Prob(pp_Prob);
        BackLayUIInfo.getAddInfo(response, flag);
    }

    /**
     * 查询所有防护方法
     *
     * @param request
     * @param response
     */
    protected void queryAllPPMethod(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 调用业务层
            List<Protection_Method> ppMethod = guideService.queryAllPP_Method();
            // 传递给客户端
            String jsonString = JSON.toJSONString(ppMethod);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除心理问题
     *
     * @param request
     * @param response
     */
    protected void deleteCp_probByCp_id(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取 rid
            int cp_id = WebUtils.parseInt(request.getParameter("cp_id"), 0);
            // 调用业务层删除该条谣言信息
            boolean flag = guideService.deleteCp_probByCp_id(cp_id);
            getDeleteInfo(response, flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改心理问题
     *
     * @param request
     * @param response
     */
    protected void editCP_Prob(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取表单参数，封装为谣言对象
            Counseling_Problem cp_prob = ConvertBean.toBeans(Counseling_Problem.class, request.getParameterMap());
            // 调用业务层实现添加
            boolean flag = guideService.editCp_prob(cp_prob);
            // 通过响应传输给客户端
            getEditRespInfo(response, flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量删除心理问题
     *
     * @param request
     * @param response
     */
    protected void batchDeleteCP_Prob(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取 id 字符串
            String ids = request.getParameter("ids");
            // 调用业务层方法删除所有选中的数据
            boolean flag = guideService.batchDeleteCP_Prob(ids);
            getBatchDeleteInfo(response, flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加心理问题
     *
     * @param request
     * @param response
     */
    protected void addCP_Prob(HttpServletRequest request, HttpServletResponse response) {
        // 获取表单参数，封装为谣言对象
        Counseling_Problem cp_Prob = ConvertBean.toBeans(Counseling_Problem.class, request.getParameterMap());
        // 调用业务层实现添加
        boolean flag = guideService.saveCp_Prob(cp_Prob);
        BackLayUIInfo.getAddInfo(response, flag);
    }

    /**
     * 查询所有心理方法
     *
     * @param request
     * @param response
     */
    protected void queryAllCMethod(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 调用业务层
            List<Counseling> counselings = guideService.queryAllCMethod();
            // 传递给客户端
            String jsonString = JSON.toJSONString(counselings);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除口罩使用问题 根据 fp_id
     *
     * @param request
     * @param response
     */
    protected void deleteFp_probByFp_id(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取 rid
            int fp_id = WebUtils.parseInt(request.getParameter("fp_id"), 0);
            // 调用业务层删除该条谣言信息
            boolean flag = guideService.deleteFp_probByFp_id(fp_id);
            getDeleteInfo(response, flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 编辑口罩使用问题
     *
     * @param request
     * @param response
     */
    protected void editFP_Prob(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取表单参数，封装为谣言对象
            faceMask_problem fp_prob = ConvertBean.toBeans(faceMask_problem.class, request.getParameterMap());
            // 调用业务层实现添加
            boolean flag = guideService.editFp_prob(fp_prob);
            // 通过响应传输给客户端
            getEditRespInfo(response, flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量删除口罩使用问题
     *
     * @param request
     * @param response
     */
    protected void batchDeleteFP_Prob(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取 id 字符串
            String ids = request.getParameter("ids");
            // 调用业务层方法删除所有选中的数据
            boolean flag = guideService.batchDeleteFP_Prob(ids);
            getBatchDeleteInfo(response, flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加口罩使用问题
     *
     * @param request
     * @param response
     */
    protected void addFP_Prob(HttpServletRequest request, HttpServletResponse response) {
        // 获取表单参数，封装为谣言对象
        faceMask_problem FP_Prob = ConvertBean.toBeans(faceMask_problem.class, request.getParameterMap());
        // 调用业务层实现添加
        boolean flag = guideService.saveFP_Prob(FP_Prob);
        BackLayUIInfo.getAddInfo(response, flag);
    }

    /**
     * 查询所有口罩使用方法
     *
     * @param request
     * @param response
     */
    protected void queryAllFM_Method(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 调用业务层
            List<Use_faceMask> faceMasks = guideService.queryAllFM_Method();
            // 传递给客户端
            String jsonString = JSON.toJSONString(faceMasks);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量删除
     *
     * @param request
     * @param response
     */
    protected void batchDeleteRumor(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取 id 字符串
            String rids = request.getParameter("rids");
            // 调用业务层方法删除所有选中的数据
            boolean flag = guideService.batchDeleteRumor(rids);
            getBatchDeleteInfo(response, flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 修改谣言
     *
     * @param request
     * @param response
     */
    protected void editRumor(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取表单参数，封装为谣言对象
            Rumor rumor = ConvertBean.toBeans(Rumor.class, request.getParameterMap());
            // 调用业务层实现添加
            boolean flag = guideService.editRumor(rumor);
            // 通过响应传输给客户端
            getEditRespInfo(response, flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 根据 rid 删除谣言信息
     *
     * @param request
     * @param response
     */
    protected void deleteRumorByRid(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取 rid
            int rid = WebUtils.parseInt(request.getParameter("rid"), 0);
            // 调用业务层删除该条谣言信息
            boolean flag = guideService.deleteRumorByRid(rid);
            getDeleteInfo(response, flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加谣言
     *
     * @param request
     * @param response
     */
    protected void saveRumor(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取表单参数，封装为谣言对象
            Rumor rumor = ConvertBean.toBeans(Rumor.class, request.getParameterMap());
            // 调用业务层实现添加
            boolean flag = guideService.saveRumor(rumor);
            JSONObject jsonObject = new JSONObject();
            if (flag) {
                jsonObject.put("success", true);
                jsonObject.put("message", "Add Success");
            } else {
                jsonObject.put("success", false);
                jsonObject.put("message", "Add Fail");
            }
            response.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据 id 批量删除就医问题
     *
     * @param request
     * @param response
     */
    protected void batchDeleteH_Prob(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取就医问题编号
            String hids = request.getParameter("hids");
            // 调用业务层删除该就医问题
            boolean flag = guideService.batchDeleteH_ProbByTreat_id(hids);
            getBatchDeleteInfo(response, flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void editHosProb(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 将请求的参数封装为一个就医问题对象
            HosProblem hosProblem = ConvertBean.toBeans(HosProblem.class, request.getParameterMap());
            // 修改操作
            boolean save = guideService.alterHosProb(hosProblem);
            // 通过响应传输给客户端
            JSONObject jsonObject = new JSONObject();
            if (save) {
                jsonObject.put("success", true);
                jsonObject.put("message", "Edit Success");
            } else {
                jsonObject.put("success", false);
                jsonObject.put("message", "Edit Fail");
            }
            response.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据就医问题编号删除就医问题
     *
     * @param request
     * @param response
     */
    protected void deleteH_ProbByTreat_id(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取就医问题编号
            int treat_id = WebUtils.parseInt(request.getParameter("treat_id"), 0);
            // 调用业务层删除该就医问题
            boolean flag = guideService.deleteH_ProbByTreat_id(treat_id);
            getDeleteInfo(response, flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加就医问题的实现
     *
     * @param request
     * @param response
     */
    protected void saveHosProb(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 将请求的参数封装为一个就医问题对象
            HosProblem hosProblem = ConvertBean.toBeans(HosProblem.class, request.getParameterMap());
//            response.setContentType("text/html;charset=GBK");
//            response.setCharacterEncoding("GBK");
            // 调用业务层实现添加操作
            boolean save = guideService.addHosProblem(hosProblem);
            JSONObject jsonObject = new JSONObject();
            if (save) {
                jsonObject.put("success", true);
                jsonObject.put("message", "Add Success");
            } else {
                jsonObject.put("success", false);
                jsonObject.put("message", "Add Success");
            }
            // 通过响应传输给客户端
            response.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过 Ajax 查询所有就医方法
     *
     * @param request
     * @param response
     */
    protected void queryAllHosMethod(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<HosRational> rationals = guideService.queryAllHosRational();
            String jsonString = JSON.toJSONString(rationals);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有谣言并返回到浏览器（通过对象.属性来进行分类【t_ensure真假性】）
     *
     * @param request
     * @param response
     */
    protected void loadRumorT_EnsureCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Rumor> rumors = guideService.queryAllRumor();
            String jsonString = JSON.toJSONString(rumors);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * AJAX 请求查询所有医生信息
     *
     * @param request
     * @param response
     */
    protected void queryAllDoctor(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Doctor> doctors = guideService.queryAllDoctor();
            String jsonString = JSON.toJSONString(doctors);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过 LayUI 查询所有就医问题
     *
     * @param request
     * @param response
     */
    protected void queryH_probForLayUI(HttpServletRequest request, HttpServletResponse response) {

        try {
            // 获取 page、limit 参数
            int pageNo = WebUtils.parseInt(request.getParameter("page"), 1);
            int pageSize = WebUtils.parseInt(request.getParameter("limit"), Page.PAGE_SIZE);

            // 接收条件查询的参数
            String h_name = request.getParameter("h_name");
            /**
             * 由于查询的条件可能会比较多，那么就将查询条件封装为一个就医问题对象
             */
            HosProblem searchHosProb = new HosProblem();
            searchHosProb.setH_name(h_name);
            // 获取心理疏导问题表总记录数
            int pageTotalCount = guideService.queryH_probTotalCountForLayUI(searchHosProb);

            // 创建 Page 对象
            Page<HosProblem> page = new Page<>(pageNo, pageSize, pageTotalCount);

            // 查询心理疏导问题表分页数据
            List<HosProblem> list = guideService.queryH_probItemsForLayUI(page.getStartIndex(), pageSize, searchHosProb);

            // 返回给客户端
            LayUIResponse layUIResponse = new LayUIResponse(0, list, pageTotalCount);
            String jsonString = JSON.toJSONString(layUIResponse);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过 LayUI 查询所有心理疏导问题
     *
     * @param request
     * @param response
     */
    protected void queryC_probForLayUI(HttpServletRequest request, HttpServletResponse response) {

        try {
            // 获取 page、limit 参数
            int pageNo = WebUtils.parseInt(request.getParameter("page"), 1);
            int pageSize = WebUtils.parseInt(request.getParameter("limit"), Page.PAGE_SIZE);

            // 将条件查询条件封装为对象
            Counseling_Problem searchCProb = ConvertBean.toBeans(Counseling_Problem.class, request.getParameterMap());

            // 获取心理疏导问题表总记录数
            int pageTotalCount = guideService.queryC_probTotalCountForLayUI(searchCProb);

            // 创建 Page 对象
            Page<Counseling_Problem> page = new Page<>(pageNo, pageSize, pageTotalCount);

            // 查询心理疏导问题表分页数据
            List<Counseling_Problem> list = guideService.queryC_probItemsForLayUI(page.getStartIndex(), pageSize, searchCProb);

            // 返回给客户端
            LayUIResponse layUIResponse = new LayUIResponse(0, list, pageTotalCount);
            String jsonString = JSON.toJSONString(layUIResponse);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过 LayUI 查询所有防护问题信息
     *
     * @param request
     * @param response
     */
    protected void queryP_probForLayUI(HttpServletRequest request, HttpServletResponse response) {

        try {
            // 获取 page、limit 参数
            int pageNo = WebUtils.parseInt(request.getParameter("page"), 1);
            int pageSize = WebUtils.parseInt(request.getParameter("limit"), Page.PAGE_SIZE);

            // 将条件查询封装为对象
            Protection_Problem searchProb = ConvertBean.toBeans(Protection_Problem.class, request.getParameterMap());
            // 获取防护问题表总记录数
            int pageTotalCount = guideService.queryP_probTotalCountForLayUI(searchProb);

            // 创建 Page 对象
            Page<Protection_Problem> page = new Page<>(pageNo, pageSize, pageTotalCount);

            // 查询防护问题表分页数据
            List<Protection_Problem> list = guideService.queryP_probItemsForLayUI(page.getStartIndex(), pageSize, searchProb);

            // 返回给客户端
            LayUIResponse layUIResponse = new LayUIResponse(0, list, pageTotalCount);
            String jsonString = JSON.toJSONString(layUIResponse);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过 LayUI 查询所有谣言信息
     *
     * @param request
     * @param response
     */
    protected void queryRumorForLayUI(HttpServletRequest request, HttpServletResponse response) {

        try {
            // 获取参数 page、limit 参数
            int pageNo = WebUtils.parseInt(request.getParameter("page"), 1);
            int pageSize = WebUtils.parseInt(request.getParameter("limit"), Page.PAGE_SIZE);


            // 接收查询条件
            String d_doctorInfo = request.getParameter("d_doctorInfo");
            /**
             * 由于查询的条件可能会比较多，那么就将查询条件封装为一个对象
             */
            Rumor searchRumor = new Rumor();
            searchRumor.setD_doctorInfo(d_doctorInfo);

            // 获取谣言表的总记录数
            int pageTotalCount = guideService.queryRumorTotalCountForLayUI(searchRumor);

            // 封装为 Page 对象
            Page<Rumor> page = new Page<>(pageNo, pageSize, pageTotalCount);

            // 查询分页数据
            List<Rumor> list = guideService.queryRumorItemsForLayUI(page.getStartIndex(), pageSize, searchRumor);

            // 返回给客户端
            LayUIResponse layUIResponse = new LayUIResponse(0, list, pageTotalCount);
            String jsonString = JSON.toJSONString(layUIResponse);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过 LayUI 查询所有口罩问题
     *
     * @param request
     * @param response
     */
    protected void queryFp_probForLayUI(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取参数 page、limit
            int pageNo = WebUtils.parseInt(request.getParameter("page"), 1);
            int pageSize = WebUtils.parseInt(request.getParameter("limit"), Page.PAGE_SIZE);

            // 将查询条件封装为 口罩使用问题 对象
            faceMask_problem searchF_Prob = ConvertBean.toBeans(faceMask_problem.class, request.getParameterMap());


            // 查询总信息数
            int pageTotalCount = guideService.queryFp_probTotalCountForLayUI(searchF_Prob);
            // 创建 Page 对象
            Page<faceMask_problem> page = new Page<>(pageNo, pageSize, pageTotalCount);
            // 查询分页数据
            List<faceMask_problem> list = guideService.queryFp_probItemsForLayUI(page.getStartIndex(), pageSize, searchF_Prob);
            // 返回给客户端
            LayUIResponse layUIResponse = new LayUIResponse(0, list, pageTotalCount);
            String jsonString = JSON.toJSONString(layUIResponse);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 使用 easyUI 删除口罩使用方法
     *
     * @param request
     * @param response
     */
    protected void easyUIDeleteFaceMaskByFm_id(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取要被删除的口罩使用方法编号
            String fm_id = request.getParameter("fm_id");
            System.out.println("请求进来了:" + fm_id);
            // 调用业务层实现删除
            boolean del = guideService.easyUIDeleteFaceMaskByFm_id(fm_id);
            String jsonString = JSON.toJSONString(del);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用 easyUI 查询所有口罩使用方法
     *
     * @param request
     * @param response
     */
    protected void easyUIQueryAllFaceMask(HttpServletRequest request, HttpServletResponse response) {
        try {
            int page = WebUtils.parseInt(request.getParameter("page"), 1);
            int rows = WebUtils.parseInt(request.getParameter("rows"), Page.PAGE_SIZE);
            int pageTotalCount = guideService.queryTotalCountForFaceMask();
            Page<Use_faceMask> pages = new Page<>(page, rows, pageTotalCount);
            List<Use_faceMask> list = guideService.queryFaceMaskForPage(page, rows);
            pages.setItems(list);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("total", pages.getPageTotalCount());
            jsonObject.put("rows", pages.getItems());
            response.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过防护方法名查询对应的防护问题并分页
     *
     * @param request
     * @param response
     */
    protected String querySProbByMName(HttpServletRequest request, HttpServletResponse response) {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        // 先查询所有的数据项 pageTotalCount

        // 查询对应防护问题的所有条数
        // 获取参数---防护方法名
        String method_name = request.getParameter("method_name");
        // 调用业务层查询相关防护问题
        int pageTotalCount = guideService.queryPageTotalCountByMName(method_name);
        // 封装为 Page 对象
        Page<Protection_Problem> page = new Page<>(pageNo, pageSize, pageTotalCount);
        // 查询对应的分页数据
        List<Protection_Problem> list = guideService.queryProbItemsByMName(page.getStartIndex(), pageSize, method_name);
        // 将数据封装到 page 对象中
        page.setItems(list);
        // 设置 url 路径
        StringBuilder sb = new StringBuilder("guide?action=querySProbByMName");
        sb.append("&method_name=" + method_name);
        page.setUrl(sb.toString());
        // 将 page 对象存入到 request 域中
        request.setAttribute("page", page);
        // 转发到 防护问题显示页面
        return "f:pages/guide/client/p_probView.jsp";
    }

    /**
     * 通过 Ajax 查询所有防护方法
     *
     * @param request
     * @param response
     */
    /*protected void queryAllPMethod(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 调用业务层查询所有防护攻略
            List<Protection_Method> list = guideService.queryAllPMethod();
            request.setAttribute("p_method", list);
            String jsonString = JSON.toJSONString(list);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 通过 request 查询所有防护方法（页对象）
     *
     * @param request
     * @param response
     */
    protected String queryAllPMethod(HttpServletRequest request, HttpServletResponse response) {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        String strategy_name = request.getParameter("strategy_name");
        // 调用业务层查询所有防护攻略条数 pageTotalCount
        int pageTotalCount = guideService.queryPageTotalCountByStrategyName(strategy_name);
        // 封装为 Page 对象
        Page<Protection_Method> page = new Page<>(pageNo, pageSize, pageTotalCount);
        // 查询对应的分页数据
        List<Protection_Method> list = guideService.queryMethodItemsBySName(page.getStartIndex(), pageSize, strategy_name);
        // 将数据封装到 page 对象中
        page.setItems(list);
        // 设置 url 路径
        StringBuilder sb = new StringBuilder("guide?action=queryAllPMethod");
        sb.append("&strategy_name=" + strategy_name);
        page.setUrl(sb.toString());
        // 将 page 对象存入到 request 域中
        request.setAttribute("page", page);
        // 转发到 防护问题显示页面
        return "f:pages/guide/client/protection_strategy.jsp";
    }


    /**
     * 根据人群分类查询对应所有的人群心理问题
     *
     * @param request
     * @param response
     * @return
     */
    protected String queryAllCounselingProbByCategory(HttpServletRequest request, HttpServletResponse response) {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        String cs_category = request.getParameter("cs_category");

        // 调用业务层查询该人群类别下所有的心理问题 pageTotalCount
        int pageTotalCount = guideService.queryPageTotalCountByCategory(cs_category);
        // 封装为 Page 对象
        Page<Counseling_Problem> page = new Page<>(pageNo, pageSize, pageTotalCount);
        // 查询对应的分页数据
        List<Counseling_Problem> list = guideService.queryHosProbItemsByCategory(page.getStartIndex(), pageSize, cs_category);
        // 将数据封装到 page 对象中
        page.setItems(list);
        // 设置 url 路径
        StringBuilder sb = new StringBuilder("guide?action=queryAllCounselingProbByCategory");
        sb.append("&cs_category=" + cs_category);
        page.setUrl(sb.toString());
        // 将 page 对象存入到 request 域中
        request.setAttribute("page", page);
        // 转发到 防护问题显示页面
        return "f:pages/guide/client/CounselingGroupView.jsp";
    }

    /**
     * 查询所有的心理疏导人群
     *
     * @param request
     * @param response
     * @return
     */
    protected String queryAllCounselingForClient(HttpServletRequest request, HttpServletResponse response) {
        // 调用业务层查询所有防护攻略
        List<Counseling> counselings = guideService.queryAllCounselingGroup();
        // 存入 session 域中
        request.getSession().setAttribute("counselings", counselings);
        return "f:pages/guide/client/CounselingGroupView.jsp";
    }

    /**
     * 根据口罩方法查询对应所有的口罩问题
     *
     * @param request
     * @param response
     * @return
     */
    protected String queryAllMaskProbByFMethod(HttpServletRequest request, HttpServletResponse response) {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        String fm_method = request.getParameter("fm_method");
        // 调用业务层查询该口罩使用方法下所有的口罩使用问题 pageTotalCount
        int pageTotalCount = guideService.queryPageTotalCountByFMethod(fm_method);
        // 封装为 Page 对象
        Page<faceMask_problem> page = new Page<>(pageNo, pageSize, pageTotalCount);
        // 查询对应的分页数据
        List<faceMask_problem> list = guideService.queryHosProbItemsByFMethod(page.getStartIndex(), pageSize, fm_method);
        // 将数据封装到 page 对象中
        page.setItems(list);
        // 设置 url 路径
        StringBuilder sb = new StringBuilder("guide?action=queryAllMaskProbByFMethod");
        sb.append("&fm_method=" + fm_method);
        page.setUrl(sb.toString());
        // 将 page 对象存入到 request 域中
        request.setAttribute("page", page);
        // 转发到 防护问题显示页面
        return "f:pages/guide/client/faceMaskMethodView.jsp";
    }

    /**
     * 查询所有口罩使用方法
     *
     * @param request
     * @param response
     * @return
     */
    protected String queryAllUseFaceMaskForClient(HttpServletRequest request, HttpServletResponse response) {
        // 调用业务层查询所有防护攻略
        List<Use_faceMask> faceMasks = guideService.queryAllUseFaceMaskMethod();
        // 存入 session 域中
        request.getSession().setAttribute("faceMasks", faceMasks);
        return "f:pages/guide/client/faceMaskMethodView.jsp";
    }

    /**
     * 通过就医方法查询就医问题 分页
     *
     * @param request
     * @param response
     * @return
     */
    protected String queryAllHosProbByHName(HttpServletRequest request, HttpServletResponse response) {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        String h_name = request.getParameter("h_name");
        // 调用业务层查询该就医方法下所有就医问题条数 pageTotalCount
        int pageTotalCount = guideService.queryPageTotalCountByHName(h_name);
        // 封装为 Page 对象
        Page<HosProblem> page = new Page<>(pageNo, pageSize, pageTotalCount);
        // 查询对应的分页数据
        List<HosProblem> list = guideService.queryHosProbItemsByHName(page.getStartIndex(), pageSize, h_name);
        // 将数据封装到 page 对象中
        page.setItems(list);
        // 设置 url 路径
        StringBuilder sb = new StringBuilder("guide?action=queryAllHosProbByHName");
        sb.append("&h_name=" + h_name);
        page.setUrl(sb.toString());
        // 将 page 对象存入到 request 域中
        request.setAttribute("page", page);
        // 转发到 防护问题显示页面
        return "f:pages/guide/client/hosMethodView.jsp";
    }

    /**
     * 查询所有就医方法
     *
     * @param request
     * @param response
     * @return
     */
    protected String queryAllHosMethodForClient(HttpServletRequest request, HttpServletResponse response) {
        // 调用业务层查询所有防护攻略
        List<HosRational> rationals = guideService.queryAllHosRational();
        // 存入 session 域中
        request.getSession().setAttribute("rationals", rationals);
        return "f:pages/guide/client/hosMethodView.jsp";
    }

    /**
     * 通过 Ajax 请求查询所有的防护攻略
     *
     * @param request
     * @param response
     */
    /*protected void queryAllStrategy(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 调用业务层查询所有防护攻略
            List<Protection_Strategy> list = guideService.queryAllStrategy();
            // 存入 request 域中
            request.setAttribute("strategy", list);
            // 转为 json
            String jsonString = JSON.toJSONString(list);
            // 写回数据
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 查询所有谣言信息
     *
     * @param request
     * @param response
     * @return
     */
    protected String queryAllRumor(HttpServletRequest request, HttpServletResponse response) {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        // 将条件查询封装为 Rumor 对象
        String t_ensure = request.getParameter("t_ensure");
        Rumor searchRumor = new Rumor();
        searchRumor.setT_ensure(t_ensure);
        // 调用业务层查询所有谣言条数 pageTotalCount
        int pageTotalCount = guideService.queryRumorPageTotalCount(searchRumor);
        // 封装为 Page 对象
        Page<Rumor> page = new Page<>(pageNo, pageSize, pageTotalCount);
        // 查询对应的分页数据
        List<Rumor> list = guideService.queryRumorItems(page.getStartIndex(), pageSize, searchRumor);
        // 将数据封装到 page 对象中
        page.setItems(list);
        // 设置 url 路径
        StringBuilder sb = new StringBuilder("guide?action=queryAllRumor");
        sb.append("&t_ensure=" + t_ensure);
        page.setUrl(sb.toString());
        // 将 page 对象存入到 request 域中
        request.setAttribute("page", page);
        // 转发到 谣言显示页面
        return "f:pages/guide/client/rumorView.jsp";
    }

    /**
     * 通过 request 请求查询所有防护攻略
     *
     * @param request
     * @param response
     */
    protected String queryAllStrategy(HttpServletRequest request, HttpServletResponse response) {
        // 调用业务层查询所有防护攻略
        List<Protection_Strategy> list = guideService.queryAllStrategy();
        // 存入 session 域中
        request.getSession().setAttribute("strategy", list);
        return "f:pages/guide/client/protection_strategy.jsp";
    }

    /**
     * 添加就医问题
     *
     * @param request
     * @param response
     */
    protected void addProblem(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 封装成对象
            HosProblem hosProblem = ConvertBean.toBeans(HosProblem.class, request.getParameterMap());
            // 调用 业务层进行插入操作
            boolean b = guideService.addHosProblem(hosProblem);
            if (b) {    // 添加成功
                // 返回到数据显示页面 treatView.jsp,并提示用户添加成功
                request.getRequestDispatcher("pages/guide/treatView.jsp?msg=success").forward(request, response);
            } else {    // 添加失败
                // 返回到添加就医问题页面 addTreatProb.jsp,并提示用户添加失败,将错误的对象放入Session域中
                request.getSession().setAttribute("hosProblem", hosProblem);
                request.getRequestDispatcher("pages/guide/addTreatProb.jsp?msg=fail").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 点击就医方法，查询所有就医问题，通过分页显示数据
     *
     * @param request
     * @param response
     */
    protected void treatment(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 查询所有并分页
            int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
            int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

            // 调用 Service 层的方法封装成 Page 对象
            // 设置总记录数
            int pageTotalCount = guideService.queryForPageTotalCount();
//            if (pageTotalCount == -1) {
//                // 没有数据,返回到 allGuide.jsp 并提示用户
//                request.getRequestDispatcher("pages/guide/allGuide.jsp?msg=NoCount").forward(request, response);
//            }
            // 声明 Page 对象
            Page<Treat_prob> page = new Page<Treat_prob>(pageNo, pageSize, pageTotalCount);
            // 查询分页的数据
            List<Treat_prob> items = guideService.queryForPageItems(page.getStartIndex(), pageSize);
            // 存入分页数据
            page.setItems(items);
            // 设置 url 访问路径
            page.setUrl("guide?action=treatment");
            // 将 page 对象放入 request 域中
            request.setAttribute("page", page);
            // 请求转发到展示页面数据
            request.getRequestDispatcher("pages/guide/treatView.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化所有可能要用的数据
     *
     * @param request
     * @param response
     */
    protected void initAllScope(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 查询医生所有数据
            List<Doctor> doctors = guideService.queryAllDoctor();
            // 将 医生数据放入 Session 域中
            request.getSession().setAttribute("doctors", doctors);

            // 查询就医方法的所有数据
            List<HosRational> rationals = guideService.queryAllHosRational();
            request.getSession().setAttribute("rationals", rationals);


            // 最后跳转到 allGuide.jsp 页面
            request.getRequestDispatcher("pages/guide/allGuide.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
