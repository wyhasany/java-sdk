/**
 *
 *    Copyright 2020, Optimizely and contributors
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.optimizely.ab.config.audience.match;

import javax.annotation.Nullable;

class SemanticVersionEqualsMatch implements Match {
    String value;

    protected SemanticVersionEqualsMatch(String value) {
        this.value = value;
    }

    @Nullable
    public Boolean eval(Object attributeValue) {
        try {
            if (this.value != null && attributeValue instanceof String) {
                SemanticVersion conditionalVersion = new SemanticVersion(value);
                SemanticVersion userSemanticVersion = new SemanticVersion((String) attributeValue);
                return userSemanticVersion.compare(conditionalVersion) == 0;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}