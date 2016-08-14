/*
 * Copyright 2016 leon chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moilioncircle.redis.replicator.cmd.impl;

import com.moilioncircle.redis.replicator.cmd.Command;
import com.moilioncircle.redis.replicator.cmd.CommandName;
import com.moilioncircle.redis.replicator.cmd.CommandParser;

/**
 * Created by leon on 8/14/16.
 */
public class ExpireAtParser implements CommandParser<ExpireAtParser.ExpireAtCommand> {
    @Override
    public ExpireAtCommand parse(CommandName cmdName, Object[] params) {
        int idx = 0;
        String key = (String) params[idx++];
        long ex = Long.parseLong((String) params[idx++]);
        return new ExpireAtCommand(key, ex);
    }

    public static class ExpireAtCommand implements Command {
        public final String key;
        public final long ex;

        public ExpireAtCommand(String key, long ex) {
            this.key = key;
            this.ex = ex;
        }

        @Override
        public String toString() {
            return "ExpireAtCommand{" +
                    "key='" + key + '\'' +
                    ", ex=" + ex +
                    '}';
        }

        @Override
        public CommandName name() {
            return CommandName.name("EXPIREAT");
        }
    }
}
