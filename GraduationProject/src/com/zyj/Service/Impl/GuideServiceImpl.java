package com.zyj.Service.Impl;

import com.zyj.Dao.GuideDao;
import com.zyj.Dao.Impl.GuideDaoImpl;
import com.zyj.Pojo.*;
import com.zyj.Service.GuideService;

import java.util.List;

/**
 * @ClassName GuideServiceImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 16:06
 * @Description: com.zyj.Service.Impl
 * @version: 1.0
 */
public class GuideServiceImpl implements GuideService {

    GuideDao dao = new GuideDaoImpl();

    @Override
    public int queryForPageTotalCount() {
        return dao.queryForPageTotalCount();
    }

    @Override
    public List<Treat_prob> queryForPageItems(int startIndex, int pageSize) {
        return dao.queryForPageItems(startIndex, pageSize);
    }

    @Override
    public List<Doctor> queryAllDoctor() {
        return dao.queryAllDoctor();
    }

    @Override
    public List<HosRational> queryAllHosRational() {
        return dao.queryAllHosRational();
    }

    @Override
    public boolean addHosProblem(HosProblem hosProblem) {
        return dao.addHosProblem(hosProblem);
    }

    @Override
    public List<Protection_Strategy> queryAllStrategy() {
        return dao.queryAllStrategy();
    }

    @Override
    public List<Protection_Method> queryAllPMethod() {
        return dao.queryAllPMethod();
    }

    @Override
    public int queryPageTotalCountByMName(String method_name) {
        return dao.queryPageTotalCountByMName(method_name);
    }

    @Override
    public List<Protection_Problem> queryProbItemsByMName(int startIndex, int pageNo, String method_name) {
        return dao.queryProbItemsByMName(startIndex, pageNo, method_name);
    }

    @Override
    public int queryPageTotalCountByStrategyName(String strategy_name) {
        return dao.queryPageTotalCountByStrategyName(strategy_name);
    }

    @Override
    public List<Protection_Method> queryMethodItemsBySName(int startIndex, int pageSize, String strategy_name) {
        return dao.queryMethodItemsBySName(startIndex, pageSize, strategy_name);
    }

    @Override
    public int queryTotalCountForFaceMask() {
        return dao.queryTotalCountForFaceMask();
    }

    @Override
    public List<Use_faceMask> queryFaceMaskForPage(int startIndex, int rows) {
        return dao.queryFaceMaskForPage(startIndex, rows);
    }

    @Override
    public boolean easyUIDeleteFaceMaskByFm_id(String fm_id) {
        return dao.easyUIDeleteFaceMaskByFm_id(fm_id);
    }

    @Override
    public int queryFp_probTotalCountForLayUI(faceMask_problem searchF_Prob) {
        return dao.queryFp_probTotalCountForLayUI(searchF_Prob);
    }

    @Override
    public List<faceMask_problem> queryFp_probItemsForLayUI(int startIndex, int pageSize, faceMask_problem searchF_Prob) {
        return dao.queryFp_probItemsForLayUI(startIndex, pageSize, searchF_Prob);
    }

    @Override
    public int queryRumorTotalCountForLayUI(Rumor searchRumor) {
        return dao.queryRumorTotalCountForLayUI(searchRumor);
    }

    @Override
    public List<Rumor> queryRumorItemsForLayUI(int startIndex, int pageSize, Rumor searchRumor) {
        return dao.queryRumorItemsForLayUI(startIndex, pageSize, searchRumor);
    }

    @Override
    public int queryP_probTotalCountForLayUI(Protection_Problem searchProb) {
        return dao.queryP_probTotalCountForLayUI(searchProb);
    }

    @Override
    public List<Protection_Problem> queryP_probItemsForLayUI(int startIndex, int pageSize, Protection_Problem searchProb) {
        return dao.queryP_probItemsForLayUI(startIndex, pageSize, searchProb);
    }

    @Override
    public int queryC_probTotalCountForLayUI(Counseling_Problem searchCProb) {
        return dao.queryC_probTotalCountForLayUI(searchCProb);
    }

    @Override
    public List<Counseling_Problem> queryC_probItemsForLayUI(int startIndex, int pageSize, Counseling_Problem searchCProb) {
        return dao.queryC_probItemsForLayUI(startIndex, pageSize, searchCProb);
    }

    @Override
    public int queryH_probTotalCountForLayUI(HosProblem searchHosProb) {
        return dao.queryH_probTotalCountForLayUI(searchHosProb);
    }

    @Override
    public List<HosProblem> queryH_probItemsForLayUI(int startIndex, int pageSize, HosProblem searchHosProb) {
        return dao.queryH_probItemsForLayUI(startIndex, pageSize, searchHosProb);
    }

    @Override
    public List<Rumor> queryAllRumor() {
        return dao.queryAllRumor();
    }

    @Override
    public boolean deleteH_ProbByTreat_id(Integer treat_id) {
        return dao.deleteH_ProbByTreat_id(treat_id);
    }

    @Override
    public boolean alterHosProb(HosProblem hosProblem) {
        return dao.alterHosProb(hosProblem);
    }

    @Override
    public boolean batchDeleteH_ProbByTreat_id(String hids) {
        return dao.batchDeleteH_ProbByTreat_id(hids);
    }

    @Override
    public boolean saveRumor(Rumor rumor) {
        return dao.saveRumor(rumor);
    }

    @Override
    public boolean deleteRumorByRid(int rid) {
        return dao.deleteRumorByRid(rid);
    }

    @Override
    public boolean editRumor(Rumor rumor) {
        return dao.editRumor(rumor);
    }

    @Override
    public boolean batchDeleteRumor(String rids) {
        return dao.batchDeleteRumor(rids);
    }

    @Override
    public List<Use_faceMask> queryAllFM_Method() {
        return dao.queryAllFM_Method();
    }

    @Override
    public boolean saveFP_Prob(faceMask_problem fp_prob) {
        return dao.saveFP_Prob(fp_prob);
    }

    @Override
    public boolean batchDeleteFP_Prob(String ids) {
        return dao.batchDeleteFP_Prob(ids);
    }

    @Override
    public boolean editFp_prob(faceMask_problem fp_prob) {
        return dao.editFp_prob(fp_prob);
    }

    @Override
    public boolean deleteFp_probByFp_id(int fp_id) {
        return dao.deleteFp_probByFp_id(fp_id);
    }

    @Override
    public List<Counseling> queryAllCMethod() {
        return dao.queryAllCMethod();
    }

    @Override
    public boolean saveCp_Prob(Counseling_Problem cp_prob) {
        return dao.saveCp_Prob(cp_prob);
    }

    @Override
    public boolean batchDeleteCP_Prob(String ids) {
        return dao.batchDeleteCP_Prob(ids);
    }

    @Override
    public boolean editCp_prob(Counseling_Problem cp_prob) {
        return dao.editCp_prob(cp_prob);
    }

    @Override
    public boolean deleteCp_probByCp_id(int cp_id) {
        return dao.deleteCp_probByCp_id(cp_id);
    }

    @Override
    public List<Protection_Method> queryAllPP_Method() {
        return dao.queryAllPP_Method();
    }

    @Override
    public boolean savePp_Prob(Protection_Problem pp_prob) {
        return dao.savePp_Prob(pp_prob);
    }

    @Override
    public boolean batchDeletePP_Prob(String ids) {
        return dao.batchDeletePP_Prob(ids);
    }

    @Override
    public boolean editPp_prob(Protection_Problem pp_prob) {
        return dao.editPp_prob(pp_prob);
    }

    @Override
    public boolean deletePp_probByPp_id(int problem_id) {
        return dao.deletePp_probByPp_id(problem_id);
    }

    @Override
    public int queryRumorPageTotalCount(Rumor searchRumor) {
        return dao.queryRumorPageTotalCount(searchRumor);
    }

    @Override
    public List<Rumor> queryRumorItems(int startIndex, int pageSize, Rumor searchRumor) {
        return dao.queryRumorItems(startIndex, pageSize, searchRumor);
    }

    @Override
    public int queryPageTotalCountByHName(String h_name) {
        return dao.queryPageTotalCountByHName(h_name);
    }

    @Override
    public List<HosProblem> queryHosProbItemsByHName(int startIndex, int pageSize, String h_name) {
        return dao.queryHosProbItemsByHName(startIndex, pageSize, h_name);
    }

    @Override
    public List<Use_faceMask> queryAllUseFaceMaskMethod() {
        return dao.queryAllUseFaceMaskMethod();
    }

    @Override
    public int queryPageTotalCountByFMethod(String fm_method) {
        return dao.queryPageTotalCountByFMethod(fm_method);
    }

    @Override
    public List<faceMask_problem> queryHosProbItemsByFMethod(int startIndex, int pageSize, String fm_method) {
        return dao.queryHosProbItemsByFMethod(startIndex, pageSize, fm_method);
    }

    @Override
    public List<Counseling> queryAllCounselingGroup() {
        return dao.queryAllCounselingGroup();
    }

    @Override
    public int queryPageTotalCountByCategory(String cs_category) {
        return dao.queryPageTotalCountByCategory(cs_category);
    }

    @Override
    public List<Counseling_Problem> queryHosProbItemsByCategory(int startIndex, int pageSize, String cs_category) {
        return dao.queryHosProbItemsByCategory(startIndex, pageSize, cs_category);
    }

    @Override
    public List<City> queryAllCity() {
        return dao.queryAllCity();
    }
}
