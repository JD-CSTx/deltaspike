/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.deltaspike.jpa.api;

import javax.enterprise.inject.Any;
import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;

/**
 * If it isn't possible to use EJBs, this interceptor adds transaction support to methods or a class.
 * The optional qualifier can be used to specify different entity managers.
 */

@InterceptorBinding
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Transactional
{
    /**
     * Optional qualifier/s which allow/s to start only specific transactions instead of one
     * for the injected {@link javax.persistence.EntityManager}s.
     * Default-value is {@link Any} which means any injected {@link javax.persistence.EntityManager}s
     * should be detected automatically and transactions for all injected {@link javax.persistence.EntityManager}s
     * will be started
     * @return target persistence-unit identifier
     */
    @Nonbinding Class<? extends Annotation>[] qualifier() default Any.class;

    //TODO remove it if we keep Any as default qualifier
    /*
    //alternative if we keep Default as default qualifier instead of Any
    / **
     * In case of false only transactions for entity-managers listed at {@link #qualifier()} will be handled
     * @return true to use the injected entity-managers and
     * false to restrict a service call to the specified entity managers
     * /
    @Nonbinding boolean autoDetection() default true;
     */
}
