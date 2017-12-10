package cn.edu.nju.software.master17.wechatdocter.web.data;

import lombok.Data;

/**
 *
 * @author csc
 * @date 2017/12/9
 */
@Data
public class UserVO {
    private Long patientId;
    private String openId;
    private String name;
    private Integer age;
    private String sex;
    private String mobile;
    private String history;
    private String password;
    private String recent;
}
