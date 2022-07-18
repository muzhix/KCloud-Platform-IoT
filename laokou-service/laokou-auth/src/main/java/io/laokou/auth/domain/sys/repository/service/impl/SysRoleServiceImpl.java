package io.laokou.auth.domain.sys.repository.service.impl;
import io.laokou.auth.domain.sys.repository.dao.SysRoleDao;
import io.laokou.auth.domain.sys.repository.service.SysRoleService;
import io.laokou.common.vo.SysRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRoleVO> getRoleListByUserId(Long userId) {
        return sysRoleDao.getRoleListByUserId(userId);
    }
}
