使用quartz做定时任务
  <bean id="createSaleGoodsTask" class="com.tianyuaninfo.tourism.task.CreateSaleGoodsTask"></bean>
    <!--查询商品详细信息到ES中-->
      <bean id="startTaskDetails" class="org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean">
          <property name = "targetObject" ref="createSaleGoodsTask" />
          <property name = "targetMethod" value="startTask" />
          <property name = "concurrent" value="false" />
      </bean>

      <bean id="createSaleGoodsTaskTrigger" class="org.springframework.scheduling.quartz.CronTriggerFactoryBean">
          <property name="jobDetail" ref="startTaskDetails"/>
          <!--每天3点-->
          <property name="cronExpression" value="0 0 3 * * ?" />
          <!-- <property name="cronExpression" value="0 10 * * * ?" />每10分钟执行一次 -->
      </bean>

 <!--项目启动，初始化执行es查询，发送数据到kafka中 开始-->
    <bean id="initMethod_SaleGoodsTrigger" class="org.springframework.scheduling.quartz.SimpleTriggerFactoryBean">
        <property name="jobDetail" ref="startTaskDetails" />
        <property name="startDelay" value="500" />
        <property name="repeatInterval" value="0" />
        <property name="repeatCount" value="0" />
    </bean>
    <bean id="initMethod_OrganizationTrigger" class="org.springframework.scheduling.quartz.SimpleTriggerFactoryBean">
        <property name="jobDetail" ref="findOrganizationDetails" />
        <property name="startDelay" value="500" />
        <property name="repeatInterval" value="0" />
        <property name="repeatCount" value="0" />
    </bean>
    <bean id="startQuertz" class="org.springframework.scheduling.quartz.SchedulerFactoryBean">
        <property name="triggers">
            <list>
                <ref bean="initMethod_SaleGoodsTrigger" />
                <ref bean="initMethod_OrganizationTrigger" />
            </list>
        </property>
    </bean>
    <!--项目启动，初始化执行es查询，发送数据到kafka中 结束-->