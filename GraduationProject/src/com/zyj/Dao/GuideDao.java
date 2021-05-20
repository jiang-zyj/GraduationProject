package com.zyj.Dao;

import com.zyj.Pojo.*;

import java.util.List;

/**
 * @ClassName GuideDao
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 16:07
 * @Description: com.zyj.Dao
 * @version: 1.0
 */
public interface GuideDao {
    int queryForPageTotalCount();

    List<Treat_prob> queryForPageItems(int startIndex, int pageSize);

    List<Doctor> queryAllDoctor();

    List<HosRational> queryAllHosRational();

    boolean addHosProblem(HosProblem hosProblem);

    List<Protection_Strategy> queryAllStrategy();

    List<Protection_Method> queryAllPMethod();

    int queryPageTotalCountByMName(String method_name);

    List<Protection_Problem> queryProbItemsByMName(int startIndex, int pageNo, String method_name);

    int queryPageTotalCountByStrategyName(String strategy_name);

    List<Protection_Method> queryMethodItemsBySName(int startIndex, int pageSize, String strategy_name);

    int queryTotalCountForFaceMask();

    List<Use_faceMask> queryFaceMaskForPage(int startIndex, int rows);

    boolean easyUIDeleteFaceMaskByFm_id(String fm_id);

    int queryFp_probTotalCountForLayUI(faceMask_problem searchF_Prob);

    List<faceMask_problem> queryFp_probItemsForLayUI(int startIndex, int pageSize,faceMask_problem searchF_Prob);

    int queryRumorTotalCountForLayUI(Rumor searchRumor);

    List<Rumor> queryRumorItemsForLayUI(int startIndex, int pageSize, Rumor searchRumor);

    int queryP_probTotalCountForLayUI(Protection_Problem searchProb);

    List<Protection_Problem> queryP_probItemsForLayUI(int startIndex, int pageSize, Protection_Problem searchProb);

    int queryC_probTotalCountForLayUI(Counseling_Problem searchCProb);

    List<Counseling_Problem> queryC_probItemsForLayUI(int startIndex, int pageSize, Counseling_Problem searchCProb);

    int queryH_probTotalCountForLayUI(HosProblem searchHosProb);

    List<HosProblem> queryH_probItemsForLayUI(int startIndex, int pageSize, HosProblem searchHosProb);

    List<Rumor> queryAllRumor();

    boolean deleteH_ProbByTreat_id(Integer treat_id);

    boolean alterHosProb(HosProblem hosProblem);

    boolean batchDeleteH_ProbByTreat_id(String hids);

    boolean saveRumor(Rumor rumor);

    boolean deleteRumorByRid(int rid);

    boolean editRumor(Rumor rumor);

    boolean batchDeleteRumor(String rids);

    List<Use_faceMask> queryAllFM_Method();

    boolean saveFP_Prob(faceMask_problem fp_prob);

    boolean batchDeleteFP_Prob(String ids);

    boolean editFp_prob(faceMask_problem fp_prob);

    boolean deleteFp_probByFp_id(int fp_id);

    List<Counseling> queryAllCMethod();

    boolean saveCp_Prob(Counseling_Problem cp_prob);

    boolean batchDeleteCP_Prob(String ids);

    boolean editCp_prob(Counseling_Problem cp_prob);

    boolean deleteCp_probByCp_id(int cp_id);

    List<Protection_Method> queryAllPP_Method();

    boolean savePp_Prob(Protection_Problem pp_prob);

    boolean batchDeletePP_Prob(String ids);

    boolean editPp_prob(Protection_Problem pp_prob);

    boolean deletePp_probByPp_id(int problem_id);

    int queryRumorPageTotalCount(Rumor searchRumor);

    List<Rumor> queryRumorItems(int startIndex, int pageSize, Rumor searchRumor);

    int queryPageTotalCountByHName(String h_name);

    List<HosProblem> queryHosProbItemsByHName(int startIndex, int pageSize, String h_name);

    List<Use_faceMask> queryAllUseFaceMaskMethod();

    int queryPageTotalCountByFMethod(String fm_method);

    List<faceMask_problem> queryHosProbItemsByFMethod(int startIndex, int pageSize, String fm_method);

    List<Counseling> queryAllCounselingGroup();

    int queryPageTotalCountByCategory(String cs_category);

    List<Counseling_Problem> queryHosProbItemsByCategory(int startIndex, int pageSize, String cs_category);

    List<City> queryAllCity();
}
