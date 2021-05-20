package com.zyj.Service;

import com.zyj.Pojo.*;

import java.util.List;

/**
 * @ClassName GuideService
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 16:06
 * @Description: com.zyj.Service
 * @version: 1.0
 */
public interface GuideService {

    /**
     * 查询就医问题所有数据的数据总数
     *
     * @return
     */
    int queryForPageTotalCount();

    /**
     * 分页查询数据
     *
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Treat_prob> queryForPageItems(int startIndex, int pageSize);

    /**
     * 查询所有医生
     *
     * @return
     */
    List<Doctor> queryAllDoctor();

    /**
     * 查询所有就医方法
     *
     * @return
     */
    List<HosRational> queryAllHosRational();

    /**
     * 添加就医问题
     *
     * @param hosProblem
     * @return
     */
    boolean addHosProblem(HosProblem hosProblem);

    /**
     * 查询所有防护攻略
     *
     * @return
     */
    List<Protection_Strategy> queryAllStrategy();

    /**
     * 查询所有防护方法
     *
     * @return
     */
    List<Protection_Method> queryAllPMethod();

    /**
     * 通过防护方法名查询对应所有的问题总数
     *
     * @param method_name
     * @return
     */
    int queryPageTotalCountByMName(String method_name);

    /**
     * 分页查询防护方法对应的防护问题的数据
     *
     * @param method_name
     * @return
     */
    List<Protection_Problem> queryProbItemsByMName(int startIndex, int pageNo, String method_name);

    /**
     * 分页查询防护方法总条数
     *
     * @param strategy_name
     * @return
     */
    int queryPageTotalCountByStrategyName(String strategy_name);

    /**
     * 分页查询防护攻略对应的防护方法的数据
     *
     * @param startIndex
     * @param pageSize
     * @param strategy_name
     * @return
     */
    List<Protection_Method> queryMethodItemsBySName(int startIndex, int pageSize, String strategy_name);


    /**
     * 通过 easyUI 查询口罩使用方法总信息数
     *
     * @return
     */
    int queryTotalCountForFaceMask();

    /**
     * 通过 easyUI 查询口罩使用分页数据
     *
     * @param startIndex
     * @param rows
     * @return
     */
    List<Use_faceMask> queryFaceMaskForPage(int startIndex, int rows);


    /**
     * 使用 easyUI ，通过口罩使用编号删除口罩使用方法
     *
     * @param fm_id
     * @return
     */
    boolean easyUIDeleteFaceMaskByFm_id(String fm_id);

    /**
     * 使用 LayUI 查询口罩使用问题总信息数
     *
     * @return
     */
    int queryFp_probTotalCountForLayUI(faceMask_problem searchF_Prob);

    /**
     * 使用 LayUI 查询口罩使用问题分页数据
     *
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<faceMask_problem> queryFp_probItemsForLayUI(int startIndex, int pageSize, faceMask_problem searchF_Prob);

    /**
     * 使用 LayUI 获取谣言表的总记录数
     *
     * @return
     */
    int queryRumorTotalCountForLayUI(Rumor searchRumor);

    /**
     * 使用 LayUI 查询谣言分页数据
     *
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Rumor> queryRumorItemsForLayUI(int startIndex, int pageSize, Rumor searchRumor);

    /**
     * 使用 LayUI 获取防护问题表总记录数
     *
     * @return
     */
    int queryP_probTotalCountForLayUI(Protection_Problem searchProb);

    /**
     * 使用 LayUI 查询防护问题表分页数据
     *
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Protection_Problem> queryP_probItemsForLayUI(int startIndex, int pageSize, Protection_Problem searchProb);

    /**
     * 使用 LayUI 获取心理疏导问题表总记录数
     *
     * @return
     */
    int queryC_probTotalCountForLayUI(Counseling_Problem searchCProb);

    /**
     * 使用 LayUI 查询心理疏导问题表分页数据
     *
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Counseling_Problem> queryC_probItemsForLayUI(int startIndex, int pageSize, Counseling_Problem searchCProb);

    /**
     * 使用 LayUI 获取就医问题表总记录数
     *
     * @return
     */
    int queryH_probTotalCountForLayUI(HosProblem searchHosProb);

    /**
     * 使用 LayUI 查询就医问题表分页数据
     *
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<HosProblem> queryH_probItemsForLayUI(int startIndex, int pageSize, HosProblem searchHosProb);

    /**
     * 查询所有谣言并返回到浏览器（通过对象.属性来进行分类【t_ensure真假性】）
     *
     * @return
     */
    List<Rumor> queryAllRumor();

    /**
     * 通过就医问题编号删除就医问题
     *
     * @param treat_id
     * @return
     */
    boolean deleteH_ProbByTreat_id(Integer treat_id);

    /**
     * 修改就医问题
     *
     * @param hosProblem
     * @return
     */
    boolean alterHosProb(HosProblem hosProblem);

    /**
     * 根据 id 批量删除就医问题
     *
     * @param hids
     * @return
     */
    boolean batchDeleteH_ProbByTreat_id(String hids);

    /**
     * 根据封装的谣言对象添加谣言
     *
     * @param rumor
     * @return
     */
    boolean saveRumor(Rumor rumor);

    /**
     * 根据 rid 删除谣言信息
     *
     * @param rid
     * @return
     */
    boolean deleteRumorByRid(int rid);

    /**
     * 修改谣言
     *
     * @param rumor
     * @return
     */
    boolean editRumor(Rumor rumor);

    /**
     * 批量删除谣言
     *
     * @param rids
     * @return
     */
    boolean batchDeleteRumor(String rids);

    /**
     * 口罩使用 条件查询
     *
     * @return
     */
    List<Use_faceMask> queryAllFM_Method();

    /**
     * 添加口罩使用问题
     *
     * @param fp_prob
     * @return
     */
    boolean saveFP_Prob(faceMask_problem fp_prob);

    /**
     * 批量删除口罩使用问题
     *
     * @param ids
     * @return
     */
    boolean batchDeleteFP_Prob(String ids);

    /**
     * 编辑口罩使用问题
     *
     * @param fp_prob
     * @return
     */
    boolean editFp_prob(faceMask_problem fp_prob);

    /**
     * 根据 fp_id  删除口罩使用问题
     *
     * @param fp_id
     * @return
     */
    boolean deleteFp_probByFp_id(int fp_id);

    /**
     * 查询所有心理方法
     *
     * @return
     */
    List<Counseling> queryAllCMethod();

    /**
     * 添加心理问题
     *
     * @param cp_prob
     * @return
     */
    boolean saveCp_Prob(Counseling_Problem cp_prob);

    /**
     * 批量删除心理问题
     *
     * @param ids
     * @return
     */
    boolean batchDeleteCP_Prob(String ids);

    /**
     * 编辑心理问题
     *
     * @param cp_prob
     * @return
     */
    boolean editCp_prob(Counseling_Problem cp_prob);

    /**
     * 删除心理问题
     *
     * @param cp_id
     * @return
     */
    boolean deleteCp_probByCp_id(int cp_id);

    /**
     * 查询所有防护方法
     *
     * @return
     */
    List<Protection_Method> queryAllPP_Method();

    /**
     * 添加防护问题
     *
     * @param pp_prob
     * @return
     */
    boolean savePp_Prob(Protection_Problem pp_prob);

    /**
     * 批量删除防护问题
     *
     * @param ids
     * @return
     */
    boolean batchDeletePP_Prob(String ids);

    /**
     * 修改防护问题
     *
     * @param pp_prob
     * @return
     */
    boolean editPp_prob(Protection_Problem pp_prob);

    /**
     * 删除防护问题
     *
     * @param problem_id
     * @return
     */
    boolean deletePp_probByPp_id(int problem_id);

    /**
     * 查询所有谣言信息的条数
     *
     * @return
     */
    int queryRumorPageTotalCount(Rumor searchRumor);

    /**
     * 查询谣言分页信息
     *
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Rumor> queryRumorItems(int startIndex, int pageSize, Rumor searchRumor);

    /**
     * 根据就医方法，查询所有就医问题条数
     *
     * @param h_name
     * @return
     */
    int queryPageTotalCountByHName(String h_name);

    /**
     * 根据就医方法，查询对应就医问题的分页数据
     *
     * @param startIndex
     * @param pageSize
     * @param h_name
     * @return
     */
    List<HosProblem> queryHosProbItemsByHName(int startIndex, int pageSize, String h_name);

    /**
     * 查询所有口罩使用方法
     *
     * @return
     */
    List<Use_faceMask> queryAllUseFaceMaskMethod();

    /**
     * 根据口罩使用方法，查询所有的的口罩使用问题
     * @param fm_method
     * @return
     */
    int queryPageTotalCountByFMethod(String fm_method);

    /**
     * 根据口罩方法，查询对应口罩使用问题的分页数据
     * @param startIndex
     * @param pageSize
     * @param fm_method
     * @return
     */
    List<faceMask_problem> queryHosProbItemsByFMethod(int startIndex, int pageSize, String fm_method);

    /**
     * 查询所有的心理疏导人群
     * @return
     */
    List<Counseling> queryAllCounselingGroup();

    /**
     * 根据人群类别，查询所有的心理问题
     * @param cs_category
     * @return
     */
    int queryPageTotalCountByCategory(String cs_category);

    /**
     * 根据人群分类，查询各人群分类心理问题的分页数据
     * @param startIndex
     * @param pageSize
     * @param cs_category
     * @return
     */
    List<Counseling_Problem> queryHosProbItemsByCategory(int startIndex, int pageSize, String cs_category);

    /**
     * 查询所有城市
     * @return
     */
    List<City> queryAllCity();

    /**
     * 查询所有就医方法
     * @return
     */
//    List<HosRational> queryAllHosMethod();
}
