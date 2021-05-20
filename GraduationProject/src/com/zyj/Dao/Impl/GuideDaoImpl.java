package com.zyj.Dao.Impl;

import com.zyj.Dao.GuideDao;
import com.zyj.Pojo.*;
import com.zyj.database.MyPoolConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName GuideDaoImpl
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 16:08
 * @Description: com.zyj.Dao.Impl
 * @version: 1.0
 */
public class GuideDaoImpl implements GuideDao {

    QueryRunner runner = new QueryRunner(MyPoolConnectionUtils.getDataSource());

    @Override
    public int queryForPageTotalCount() {
        try {
            String sql = "select count(*) from hospitalize_question, hospitalize_rational where hospitalize_question.h_name = hospitalize_rational.h_name";
            Number number = (Number) runner.query(sql, new ScalarHandler());
            return number.intValue() > 0 ? number.intValue() : -1;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Treat_prob> queryForPageItems(int startIndex, int pageSize) {
        try {
            String sql = "select * from hospitalize_question limit ?,?";
            return runner.query(sql, new BeanListHandler<Treat_prob>(Treat_prob.class), startIndex, pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Doctor> queryAllDoctor() {
        try {
            String sql = "select * from doctor";
            return runner.query(sql, new BeanListHandler<Doctor>(Doctor.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<HosRational> queryAllHosRational() {
        try {
            String sql = "select * from hospitalize_rational";
            return runner.query(sql, new BeanListHandler<HosRational>(HosRational.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean addHosProblem(HosProblem hosProblem) {
        try {
            String sql = "insert into hospitalize_question values(null,?,?,?,?)";
            int i = runner.update(sql, hosProblem.getTreat_prob(), hosProblem.getTreat_ans(), hosProblem.getD_doctorInfo(), hosProblem.getH_name());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Protection_Strategy> queryAllStrategy() {
        try {
            String sql = "select * from protection_strategy";
            return runner.query(sql, new BeanListHandler<Protection_Strategy>(Protection_Strategy.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Protection_Method> queryAllPMethod() {
        try {
            String sql = "select * from protection_method";
            return runner.query(sql, new BeanListHandler<Protection_Method>(Protection_Method.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryPageTotalCountByMName(String method_name) {
        try {
            String sql = "select count(*) from protection_problem where method_name = ?";
            Number number = (Number) runner.query(sql, new ScalarHandler(), method_name);
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Protection_Problem> queryProbItemsByMName(int startIndex, int pageNo, String method_name) {
        try {
            String sql = "select * from protection_problem where method_name = ? limit ?,?";
            return runner.query(sql, new BeanListHandler<Protection_Problem>(Protection_Problem.class), method_name, startIndex, pageNo);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryPageTotalCountByStrategyName(String strategy_name) {
        try {
            String sql = "select count(*) from protection_method where strategy_name = ?";
            Number number = (Number) runner.query(sql, new ScalarHandler(), strategy_name);
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Protection_Method> queryMethodItemsBySName(int startIndex, int pageSize, String strategy_name) {
        try {
            String sql = "select * from protection_method where strategy_name = ? limit ?,?";
            return runner.query(sql, new BeanListHandler<Protection_Method>(Protection_Method.class), strategy_name, startIndex, pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryTotalCountForFaceMask() {
        try {
            String sql = "select count(*) from use_facemask";
            Number number = (Number) runner.query(sql, new ScalarHandler());
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Use_faceMask> queryFaceMaskForPage(int startIndex, int rows) {
        try {
            String sql = "select * from use_facemask limit ?,?";
            return runner.query(sql, new BeanListHandler<Use_faceMask>(Use_faceMask.class), startIndex, rows);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean easyUIDeleteFaceMaskByFm_id(String fm_id) {
        try {
            String sql = "delete from use_facemask where fm_id = ?";
            int i = runner.update(sql, fm_id);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryFp_probTotalCountForLayUI(faceMask_problem searchF_Prob) {
        try {
            String sql = "select count(*) from facemask_problem where 1 = 1 ";
            if (searchF_Prob != null) {
                String fm_method = searchF_Prob.getFm_method();
                if (fm_method != null) {
                    sql += "and fm_method = '" + fm_method + "'";
                }
            }
            Number number = (Number) runner.query(sql, new ScalarHandler());
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<faceMask_problem> queryFp_probItemsForLayUI(int startIndex, int pageSize,faceMask_problem searchF_Prob) {
        try {
            String sql = "select * from facemask_problem where 1 = 1 ";
            if (searchF_Prob != null) {
                String fm_method = searchF_Prob.getFm_method();
                if (fm_method != null) {
                    sql += "and fm_method = '" + fm_method + "'";
                }
            }
            sql += " limit ?,?";
            return runner.query(sql, new BeanListHandler<faceMask_problem>(faceMask_problem.class), startIndex, pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryRumorTotalCountForLayUI(Rumor searchRumor) {
        try {
            String sql = "select count(*) from rumor where 1 = 1";
            if (searchRumor != null) {
                String d_doctorInfo = searchRumor.getD_doctorInfo();
                if (d_doctorInfo != null) {
                    sql += " and d_doctorInfo = '" + d_doctorInfo + "'";
                }
            }
            Number number = (Number) runner.query(sql, new ScalarHandler());
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Rumor> queryRumorItemsForLayUI(int startIndex, int pageSize, Rumor searchRumor) {
        try {
            String sql = "select * from rumor where 1 = 1 ";
            if (searchRumor != null) {
                String d_doctorInfo = searchRumor.getD_doctorInfo();
                if (d_doctorInfo != null) {
                    sql += "and d_doctorInfo = '" + d_doctorInfo + "'";
                }
            }
            sql += " limit ?,?";
            return runner.query(sql, new BeanListHandler<Rumor>(Rumor.class), startIndex, pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryP_probTotalCountForLayUI(Protection_Problem searchProb) {
        try {
            String sql = "select count(*) from protection_problem where 1 = 1 ";
            if (searchProb != null) {
                String method_name = searchProb.getMethod_name();
                if (method_name != null) {
                    sql += "and method_name = '" + method_name + "'";
                }
            }
            Number number = (Number) runner.query(sql, new ScalarHandler());
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Protection_Problem> queryP_probItemsForLayUI(int startIndex, int pageSize, Protection_Problem searchProb) {
        try {
            String sql = "select * from protection_problem where 1 = 1 ";
            if (searchProb != null) {
                String method_name = searchProb.getMethod_name();
                if (method_name != null) {
                    sql += "and method_name = '" + method_name + "'";
                }
            }
            sql += " limit ?,?";
            return runner.query(sql, new BeanListHandler<Protection_Problem>(Protection_Problem.class), startIndex, pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryC_probTotalCountForLayUI(Counseling_Problem searchCProb) {
        try {
            String sql = "select count(*) from counseling_problem where 1 = 1 ";
            if (searchCProb != null) {
                String cs_category = searchCProb.getCs_category();
                if (cs_category != null) {
                    sql += "and cs_category = '" + cs_category + "'";
                }
            }
            Number number = (Number) runner.query(sql, new ScalarHandler());
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Counseling_Problem> queryC_probItemsForLayUI(int startIndex, int pageSize, Counseling_Problem p) {
        try {
            String sql = "select * from counseling_problem where 1 = 1 ";
            if (p != null) {
                String cs_category = p.getCs_category();
                if (cs_category != null) {
                    sql += "and cs_category = '" + cs_category + "'";
                }
            }
            sql += " limit ?,?";
            return runner.query(sql, new BeanListHandler<Counseling_Problem>(Counseling_Problem.class), startIndex, pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryH_probTotalCountForLayUI(HosProblem searchHosProb) {
        try {
            String sql = "select count(*) from hospitalize_question where 1 = 1 ";
            if (searchHosProb != null) {
                String h_name = searchHosProb.getH_name();
                if (h_name != null) {
                    sql += "and h_name = '" + h_name + "'";
                }
            }
            Number number = (Number) runner.query(sql, new ScalarHandler());
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<HosProblem> queryH_probItemsForLayUI(int startIndex, int pageSize, HosProblem searchHosProb) {
        try {
            String sql = "select * from hospitalize_question where 1 = 1 ";
            if (searchHosProb != null) {
                String h_name = searchHosProb.getH_name();
                if (h_name != null) {
                    sql += "and h_name = '" + h_name + "'";
                }
            }
            sql += " limit ?,?";
            return runner.query(sql, new BeanListHandler<HosProblem>(HosProblem.class), startIndex, pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Rumor> queryAllRumor() {
        try {
            String sql = "select * from rumor";
            return runner.query(sql, new BeanListHandler<Rumor>(Rumor.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deleteH_ProbByTreat_id(Integer treat_id) {
        try {
            String sql = "delete from hospitalize_question where treat_id = ?";
            int i = runner.update(sql, treat_id);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean alterHosProb(HosProblem h) {
        try {
            String sql = "update hospitalize_question set treat_prob = ?, treat_ans = ?, d_doctorInfo = ?, h_name = ? where treat_id = ?";
            int i = runner.update(sql, h.getTreat_prob(), h.getTreat_ans(), h.getD_doctorInfo(), h.getH_name(), h.getTreat_id());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean batchDeleteH_ProbByTreat_id(String hids) {
        try {
            String sql = "delete from hospitalize_question where treat_id in (" + hids + ")";
            int i = runner.update(sql);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean saveRumor(Rumor rumor) {
        try {
            String sql = "insert into rumor values (null,?,?,?,?,?)";
            int i = runner.update(sql,rumor.getR_question(),rumor.getR_shortAnswer(),rumor.getR_answer(),rumor.getD_doctorInfo(),rumor.getT_ensure());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deleteRumorByRid(int rid) {
        try {
            String sql = "delete from rumor where rid = ?";
            int i = runner.update(sql, rid);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean editRumor(Rumor r) {
        try {
            String sql = "update rumor set r_question = ?, r_shortAnswer = ?, r_answer = ?, d_doctorInfo = ?, t_ensure = ? where rid = ?";
            int i = runner.update(sql,r.getR_question(),r.getR_shortAnswer(),r.getR_answer(),r.getD_doctorInfo(),r.getT_ensure(),r.getRid());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean batchDeleteRumor(String rids) {
        try {
            String sql = "delete from rumor where rid in (" + rids + ")";
            int i = runner.update(sql);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Use_faceMask> queryAllFM_Method() {
        try {
            String sql = "select * from use_facemask";
            return runner.query(sql,new BeanListHandler<Use_faceMask>(Use_faceMask.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean saveFP_Prob(faceMask_problem fp_prob) {
        try {
            String sql = "insert into facemask_problem values (null,?,?,?,?)";
            int i = runner.update(sql,fp_prob.getFp_question(),fp_prob.getD_doctorInfo(),fp_prob.getFp_answer(), fp_prob.getFm_method());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean batchDeleteFP_Prob(String ids) {
        try {
            String sql = "delete from facemask_problem where fp_id in (" + ids + ")";
            int i = runner.update(sql);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean editFp_prob(faceMask_problem fp_prob) {
        try {
            String sql = "update facemask_problem set fp_question = ?, d_doctorInfo = ?, fp_answer = ?, fm_method = ? where fp_id = ?";
            int i = runner.update(sql,fp_prob.getFp_question(),fp_prob.getD_doctorInfo(),fp_prob.getFp_answer(), fp_prob.getFm_method(), fp_prob.getFp_id());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deleteFp_probByFp_id(int fp_id) {
        try {
            String sql = "delete from facemask_problem where fp_id = ?";
            int i = runner.update(sql, fp_id);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Counseling> queryAllCMethod() {
        try {
            String sql = "select * from counseling";
            return runner.query(sql,new BeanListHandler<Counseling>(Counseling.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean saveCp_Prob(Counseling_Problem cp) {
        try {
            String sql = "insert into counseling_problem values (null,?,?,?,?)";
            int i = runner.update(sql,cp.getCp_problem(),cp.getD_doctorInfo(),cp.getCp_answer(), cp.getCs_category());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean batchDeleteCP_Prob(String ids) {
        try {
            String sql = "delete from counseling_problem where cp_id in (" + ids + ")";
            int i = runner.update(sql);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean editCp_prob(Counseling_Problem cp) {
        try {
            String sql = "update counseling_problem set cp_problem = ?, d_doctorInfo = ?, cp_answer = ?, cs_category = ? where cp_id = ?";
            int i = runner.update(sql,cp.getCp_problem(),cp.getD_doctorInfo(),cp.getCp_answer(),cp.getCs_category(),cp.getCp_id());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deleteCp_probByCp_id(int cp_id) {
        try {
            String sql = "delete from counseling_problem where cp_id = ?";
            int i = runner.update(sql, cp_id);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Protection_Method> queryAllPP_Method() {
        try {
            String sql = "select * from protection_method";
            return runner.query(sql,new BeanListHandler<Protection_Method>(Protection_Method.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean savePp_Prob(Protection_Problem pp) {
        try {
            String sql = "insert into protection_problem values (null,?,?,?,?)";
            int i = runner.update(sql,pp.getProblem_question(), pp.getD_doctorInfo(), pp.getProblem_answer(), pp.getMethod_name());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean batchDeletePP_Prob(String ids) {
        try {
            String sql = "delete from protection_problem where problem_id in (" + ids + ")";
            int i = runner.update(sql);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean editPp_prob(Protection_Problem pp) {
        try {
            String sql = "update protection_problem set problem_question = ?, d_doctorInfo = ?, problem_answer = ?, method_name = ? where problem_id = ?";
            int i = runner.update(sql,pp.getProblem_question(), pp.getD_doctorInfo(), pp.getProblem_answer(), pp. getMethod_name(), pp.getProblem_id());
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deletePp_probByPp_id(int problem_id) {
        try {
            String sql = "delete from protection_problem where problem_id = ?";
            int i = runner.update(sql, problem_id);
            return i > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryRumorPageTotalCount(Rumor searchRumor) {
        try {
            String sql = "select count(*) from rumor where 1 = 1 ";
            if (searchRumor != null) {
                String t_ensure = searchRumor.getT_ensure();
                if (t_ensure != null) {
                    sql += "and t_ensure = " + t_ensure + "";
                }
            }
            Number number = (Number) runner.query(sql, new ScalarHandler());
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Rumor> queryRumorItems(int startIndex, int pageSize, Rumor searchRumor) {
        try {
            String sql = "select * from rumor where 1 = 1 ";
            if (searchRumor != null) {
                String t_ensure = searchRumor.getT_ensure();
                if (t_ensure != null) {
                    sql += "and t_ensure = " + t_ensure + "";
                }
            }
            sql += " limit ?,?";
            return runner.query(sql,new BeanListHandler<Rumor>(Rumor.class),startIndex,pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryPageTotalCountByHName(String h_name) {
        try {
            String sql = "select count(*) from hospitalize_question where h_name = ?";
            Number number = (Number) runner.query(sql, new ScalarHandler(), h_name);
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<HosProblem> queryHosProbItemsByHName(int startIndex, int pageSize, String h_name) {
        try {
            String sql = "select * from hospitalize_question where h_name = ? limit ?,?";
            return runner.query(sql, new BeanListHandler<HosProblem>(HosProblem.class), h_name,startIndex, pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Use_faceMask> queryAllUseFaceMaskMethod() {
        try {
            String sql = "select * from use_facemask";
            return runner.query(sql,new BeanListHandler<Use_faceMask>(Use_faceMask.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryPageTotalCountByFMethod(String fm_method) {
        try {
            String sql = "select count(*) from facemask_problem where fm_method = ?";
            Number number = (Number) runner.query(sql, new ScalarHandler(), fm_method);
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<faceMask_problem> queryHosProbItemsByFMethod(int startIndex, int pageSize, String fm_method) {
        try {
            String sql = "select * from facemask_problem where fm_method = ? limit ?,?";
            return runner.query(sql, new BeanListHandler<faceMask_problem>(faceMask_problem.class), fm_method,startIndex, pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Counseling> queryAllCounselingGroup() {
        try {
            String sql = "select * from counseling";
            return runner.query(sql,new BeanListHandler<Counseling>(Counseling.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int queryPageTotalCountByCategory(String cs_category) {
        try {
            String sql = "select count(*) from counseling_problem where cs_category = ?";
            Number number = (Number) runner.query(sql, new ScalarHandler(), cs_category);
            return number.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Counseling_Problem> queryHosProbItemsByCategory(int startIndex, int pageSize, String cs_category) {
        try {
            String sql = "select * from counseling_problem where cs_category = ? limit ?,?";
            return runner.query(sql, new BeanListHandler<Counseling_Problem>(Counseling_Problem.class), cs_category,startIndex, pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<City> queryAllCity() {
        try {
            String sql = "select * from city";
            return runner.query(sql,new BeanListHandler<City>(City.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
