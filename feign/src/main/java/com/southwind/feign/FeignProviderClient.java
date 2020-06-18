package com.southwind.feign;

import com.southwind.entity.Student;
import com.southwind.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
//value里面是服务提供者在注册中心的名称,fallback熔断机制里的降级处理，将错误情况映射到我们做了处理的文件里，返回值类型为.class
@FeignClient(value = "provider",fallback = FeignError.class)
public interface FeignProviderClient {

    @GetMapping(value = "/student/findAll")
    public Collection<Student> findAll();

    @GetMapping(value = "/student/index")
    public String index();
}
