/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.pires.example;

import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.IMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This application demonstrates the bootstrapping of an Hazelcast cluster, on
 * top of a GCE environment.
 */
public class App {

  private static final Logger log = LoggerFactory
      .getLogger(App.class.getName());

  public static void main(String[] args) throws Exception {
    Config cfg = new ClasspathXmlConfig("hazelcast.xml");
    cfg.setInstanceName("example");
    IMap<String, String> map = Hazelcast.newHazelcastInstance(cfg).getMap(
        "example-map");
    assert map != null;
  }

}
