package io.laokou.admin.interfaces.dto;
import lombok.Data;
import java.util.List;
@Data
public class RoleDTO {

    private Long id;

    private String name;

    private Integer sort;

    private List<Long> menuIds;

}
