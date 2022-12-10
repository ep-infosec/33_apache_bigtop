/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.bigtop.datagenerators.samplers.samplers;

import java.util.Random;

import org.apache.bigtop.datagenerators.samplers.SeedFactory;

public class UniformSampler implements Sampler<Double>
{
	final Random rng;
	final double lowerbound;
	final double upperbound;

	public UniformSampler(SeedFactory seedFactory)
	{
		rng = new Random(seedFactory.getNextSeed());
		lowerbound = 0.0;
		upperbound = 1.0;
	}

	public UniformSampler(double lowerbound, double upperbound, SeedFactory seedFactory)
	{
		rng = new Random(seedFactory.getNextSeed());
		this.lowerbound = lowerbound;
		this.upperbound = upperbound;
	}

	public Double sample()
	{
		return (upperbound - lowerbound) * rng.nextDouble() + lowerbound;
	}
}
