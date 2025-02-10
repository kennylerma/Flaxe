/*
 * Copyright (c) 2019 Bishton Software Solutions (www.bishtonsoftware.com)
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

package com.bishtonsoftware.flaxe;

import java.util.ArrayList;
import java.util.List;

/*********************************************************
 * List of patterns that we'd like to replace when moving from ActionScript to Haxe
 * without using the as3hx converter tool.
 *********************************************************/

public class Patterns {
	private final List<CustomPattern> m_patterns = new ArrayList<>();

	public Patterns() {
		m_patterns.add(new CustomPattern(":int", ":Int"));
		m_patterns.add(new CustomPattern(":void", ":Void"));
		m_patterns.add(new CustomPattern(":Number", ":Float"));
		m_patterns.add(new CustomPattern(":Boolean", ":Bool"));
		m_patterns.add(new CustomPattern(":uint", ":UInt")); // Not native on all platforms see: https://api.haxe.org/UInt.html
		m_patterns.add(new CustomPattern("Vector.<int>", "Vector<Int>"));
		m_patterns.add(new CustomPattern("Vector.<Boolean>", "Vector<Bool>"));
		m_patterns.add(new CustomPattern("Vector.<Number>", "Vector<Float>"));
		m_patterns.add(new CustomPattern("[int]", "[Int]"));
		m_patterns.add(new CustomPattern("Vector.<", "Vector<"));
		m_patterns.add(new CustomPattern(">[]", ">()"));
		m_patterns.add(new CustomPattern("import flash.", "import openfl."));
		m_patterns.add(new CustomPattern("import openfl.utils.Dictionary;", ""));
		m_patterns.add(new CustomPattern("import src.", "import "));
		m_patterns.add(new CustomPattern(":Dictionary;", ":Map<>;"));
		m_patterns.add(new CustomPattern(":Dictionary,", ":Map<>,"));
		m_patterns.add(new CustomPattern(":Dictionary=", ":Map<>="));
		m_patterns.add(new CustomPattern(":Dictionary ", ":Map<> "));
		m_patterns.add(new CustomPattern("new Dictionary(", "new Map<>("));
		m_patterns.add(new CustomPattern("new <int>", "new Vector<Int>"));
		m_patterns.add(new CustomPattern("new <Boolean>", "new Vector<Bool>"));
		m_patterns.add(new CustomPattern("new <Number>", "new Vector<Float>"));
		m_patterns.add(new CustomPattern("new <", "new Vector<"));
		m_patterns.add(new CustomPattern("function get ", "function get_"));
		m_patterns.add(new CustomPattern("function set ", "function set_"));
		m_patterns.add(new CustomPattern("public class", "class"));
		m_patterns.add(new CustomPattern("protected function", " function"));
		m_patterns.add(new CustomPattern("public var failModesMenu:FailModesMenu;", ""));
		m_patterns.add(new CustomPattern("parseFloat", "Std.parseFloat"));
	}

	public List<CustomPattern> getPatterns() {
		return m_patterns;
	}
}
