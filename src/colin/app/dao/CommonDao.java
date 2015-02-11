package colin.app.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.*;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2014/12/26.
 */
@Repository
public class CommonDao<T>{
    // logger日志对象
    protected Logger log = Logger.getLogger(this.getClass());
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    //获取到Criteria
    private Criteria getCurrentCriteria(Class obj) {
        return this.hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(obj);
    }

    public CommonDao() {

    }

    /**
     * 添加一个对象
     */
    public T addObject(T obj) {
        this.hibernateTemplate.save(obj);
        return obj;
    }

    /**
     * 删除一个对象
     */
    public T deleteObject(T obj) {
        this.hibernateTemplate.delete(obj);
        return obj;
    }

    /**
     * 更新一个对象
     */
    public T updateObject(T obj) {
        this.hibernateTemplate.update(obj);
        return obj;
    }

    /**
     * 排序+分页功能+条件查询
     *
     * @param <E>
     * @param cl       要操作的数据对象
     * @param map      条件参数
     * @param orderstr 排序字段 如果为null不排序
     * @param beginpos 分页起点 如果为null不分页
     * @param count    每页的记录总数 如果为null不分页
     * @return 返回List集合
     */
    public <E> List<E> getOrderObjects(final Class cl, final Map map,
                                       final String orderstr, final Integer beginpos, final Integer count) {
        Criteria cri = this.getCurrentCriteria(cl);
        if (map != null && map.isEmpty()) {
            Set keyset = map.keySet();
            for (Object key : keyset) {
                if (key == null || map.get(key) == null) {
                    continue;
                }
                // 如果对应的值是字符串类型，我就是用like匹配
                if (map.get(key).getClass() == String.class) {
                    cri.add(Restrictions.like(key.toString(), map
                            .get(key)));
                } else {
                    cri.add(Restrictions.eq(key.toString(), map
                            .get(key)));
                }
            }
        }
        if (orderstr != null) {
            cri.addOrder(Order.desc(orderstr));
        }
        if (beginpos != null) {
            cri.setFirstResult(beginpos);
        } else {
            cri.setFirstResult(0);
        }
        if (count != null) {
            cri.setMaxResults(count);
        }
        List<E> list = cri.list();

        return list;
    }

    /**
     * 分页查询 ，传一个hql语句. 和一个参数数组.
     *
     * @param hql       hql语句
     * @param bindValue 数组参数
     * @param first     分页起点
     * @param count     每页的记录总数
     * @return 返回List集合
     */
    public List pageQuery(final String hql, final Object[] bindValue,
                          final Integer first, final Integer count) {
        Session currentSession = this.hibernateTemplate.getSessionFactory().getCurrentSession();
        Query query = currentSession.createQuery(hql);
        if (bindValue != null && bindValue.length >= 1) {
            Type[] types = typesFactory(bindValue);
            query.setParameters(bindValue, types);
        }
        if (first != null && first.intValue() >= 0) {
            query.setFirstResult(first);
            if (count != null && count.intValue() >= 0)
                query.setMaxResults(count);
        }
        List result = query.list();
        return result;

    }

    /**
     * 获取对象对应参数的类型
     *
     * @param bindValue
     * @return
     */
    private final Type[] typesFactory(Object[] bindValue) {
        int count = bindValue.length;
        Type[] types = new Type[count];
        for (int i = 0; i < count; i++) {
            if (bindValue[i].getClass().getName().endsWith("String")) {
                types[i] = new StringType();
            } else if (bindValue[i].getClass().getName().endsWith("Integer")) {
                types[i] = new IntegerType();
            } else if (bindValue[i].getClass().getName().endsWith("Float")) {
                types[i] = new FloatType();
            } else if (bindValue[i].getClass().getName().endsWith("Date")) {
                types[i] = new DateType();
            }
        }
        return types;
    }

    /**
     * 查询某个类的全部对象
     *
     * @param <E>
     * @param c   查询类的class
     * @return
     */
    public <E> List<E> selectAllObject(final Class c) {
        Criteria cri = this.getCurrentCriteria(c);
        List<E> list = cri.list();
        return list;
    }

    /**
     * 根据 主键 查询某个对象
     *
     * @param <E>
     * @param c
     * @param id
     * @return
     */
    public <E> E selectObjectById(final Class c, final Serializable id) {
        E e = (E) this.hibernateTemplate.load(c, id);
        return e;
    }

    /**
     * 根据条件,查询一个对象.
     *
     * @param <E>
     * @param c
     * @param map map放条件查询参数 调用的时候?: String username="xiejin" ;
     *            map.put("username",username);
     * @return
     */
    public <E> E selectUniqueObject(final Class c, final Map map) {
        Criteria cri = this.getCurrentCriteria(c);
        cri.add(Restrictions.allEq(map));
        return (E) cri.uniqueResult();
    }

    /**
     * 带条件的查询.返回list集合
     *
     * @param <E>
     * @param c
     * @param map 根据map里面放置的参数
     * @return 返回一个list对象集合
     */
    public <E> List<E> seletcObjectByMap(final Class c, final Map map) {
        Criteria cri = this.getCurrentCriteria(c);
        cri.add(Restrictions.allEq(map));
        List<E> e = cri.list();
        return e;

    }

    /**
     * 一个泛型方法:支持条件查询,排序,分页查询.
     *
     * @param <E>        类别
     * @param cl         需要查询的类
     * @param map        map中put("uname","谢晋"); null or map
     *                   模糊查询用("uname","%"+uname+"%")
     * @param orderStr   是否需要排序(升序) null or "属性字段"
     * @param beginIndex 分页开始位置 null or Integer
     * @param count      记录条数 null or Integer
     * @return
     */
    @SuppressWarnings("unchecked")
    public <E> List<E> selectObjInfoByMapCondtionAndOrderAndPageQuery(
            final Class cl, final Map map, final String orderStr,
            final Integer beginIndex, final Integer count) {

                        // 使用 Criteria查询 代替复杂得hql语句;
                        Criteria cri = this.getCurrentCriteria(cl);
                        // 对map进行判断
                        if (map != null) {
                            Set keyset = map.keySet();
                            for (Object key : keyset) {
                                // 如果为空则继续遍历
                                if (key == null || map.get(key) == null) {
                                    continue;
                                }
                                // 如果是参数值是字符串则用模糊查询. like 匹配
                                if (map.get(key).getClass() == String.class) {
                                    cri.add(Restrictions.like(key.toString(), map
                                            .get(key)));
                                } else {
                                    cri.add(Restrictions.eq(key.toString(), map
                                            .get(key)));
                                }
                            }
                        }
                        // 对orderStr 进行判断
                        if (orderStr != null) {
                            cri.addOrder(Order.asc(orderStr));// 升序
                        }
                        // 对分页 进行判断
                        if (beginIndex != null && beginIndex.intValue() >= 0) {
                            cri.setFirstResult(beginIndex.intValue());
                            if (count != null && count.intValue() >= 0) {
                                cri.setMaxResults(count.intValue());
                            }
                        }
                        return (List<E>) cri.list();

    }
}
