package org.study.entities;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.study.utils.birthdayUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName student
 */
@TableName(value = "student")
@Data
public class Student implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 学号
     */
    @NotNull(message = "学号不能为空!")
    @TableId
    private Integer studentId;
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空!")
    private String studentName;
    /**
     * 性别
     */
    @NotNull(message = "性别不能为空!")
    private Integer gender;
    /**
     * 出生时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;
    /**
     * 住址
     */
    private String address;
    /**
     * 专业表
     */
    private Integer professionalId;
    /**
     * 总学分
     */
    private Integer totalCredits;
    /**
     * 备注
     */
    private String remark;
    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer deleted;
    /**
     * 锁同步
     */
    @Version
    private Integer version;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Student other = (Student) that;
        return (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
                && (this.getStudentName() == null ? other.getStudentName() == null : this.getStudentName().equals(other.getStudentName()))
                && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
                && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
                && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
                && (this.getProfessionalId() == null ? other.getProfessionalId() == null : this.getProfessionalId().equals(other.getProfessionalId()))
                && (this.getTotalCredits() == null ? other.getTotalCredits() == null : this.getTotalCredits().equals(other.getTotalCredits()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
                && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getStudentName() == null) ? 0 : getStudentName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getProfessionalId() == null) ? 0 : getProfessionalId().hashCode());
        result = prime * result + ((getTotalCredits() == null) ? 0 : getTotalCredits().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentId=").append(studentId);
        sb.append(", studentName=").append(studentName);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthdayUtil.timeFormat(birthday));
        sb.append(", address=").append(address);
        sb.append(", professionalId=").append(professionalId);
        sb.append(", totalCredits=").append(totalCredits);
        sb.append(", remark=").append(remark);
        sb.append(", deleted=").append(deleted);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}