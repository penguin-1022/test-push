package com.jd.laf.config.demo.common.bo;

import java.util.List;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/6/26
 * @since todo
 */
public class StdClass {

    private String className;
    private DateBean createDate;
    private List<StdStudent> studentList;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public DateBean getCreateDate() {
        return createDate;
    }

    public void setCreateDate(DateBean createDate) {
        this.createDate = createDate;
    }

    public List<StdStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StdStudent> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "StdClass{" +
                "className='" + className + '\'' +
                ", createDate=" + createDate +
                ", studentList=" + studentList +
                '}';
    }
}
