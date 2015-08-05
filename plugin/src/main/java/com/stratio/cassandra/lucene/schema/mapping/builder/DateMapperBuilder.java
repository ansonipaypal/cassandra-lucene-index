/*
 * Copyright 2015, Stratio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stratio.cassandra.lucene.schema.mapping.builder;

import com.stratio.cassandra.lucene.schema.mapping.DateMapper;
import org.codehaus.jackson.annotate.JsonProperty;

import java.text.SimpleDateFormat;

/**
 * @author Andres de la Pena {@literal <adelapena@stratio.com>}
 */
public class DateMapperBuilder extends MapperBuilder<DateMapper> {

    @JsonProperty("indexed")
    private Boolean indexed;

    @JsonProperty("sorted")
    private Boolean sorted;

    @JsonProperty("pattern")
    private String pattern;

    /**
     * Sets if the field supports searching.
     *
     * @param indexed if the field supports searching.
     * @return This.
     */
    public DateMapperBuilder indexed(Boolean indexed) {
        this.indexed = indexed;
        return this;
    }

    /**
     * Sets if the field supports sorting.
     *
     * @param sorted if the field supports sorting.
     * @return This.
     */
    public DateMapperBuilder sorted(Boolean sorted) {
        this.sorted = sorted;
        return this;
    }

    /**
     * Sets the {@link SimpleDateFormat} pattern to be used.
     *
     * @param pattern The {@link SimpleDateFormat} pattern to be used.
     * @return This.
     */
    public DateMapperBuilder pattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    /**
     * Returns the {@link DateMapper} represented by this {@link MapperBuilder}.
     *
     * @param name The name of the {@link DateMapper} to be built.
     * @return The {@link DateMapper} represented by this.
     */
    @Override
    public DateMapper build(String name) {
        return new DateMapper(name, indexed, sorted, pattern);
    }
}