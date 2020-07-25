/*
 * Copyright 2020 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.tatiyanupanwong.supasin.android.libraries.huawei.maps.utils.data.geojson;

import com.huawei.hms.maps.model.LatLng;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GeoJsonMultiPointTest {
    private GeoJsonMultiPoint mp;

    @Test
    public void testGetType() {
        List<GeoJsonPoint> points = new ArrayList<>();
        points.add(new GeoJsonPoint(new LatLng(0, 0)));
        points.add(new GeoJsonPoint(new LatLng(5, 5)));
        points.add(new GeoJsonPoint(new LatLng(10, 10)));
        mp = new GeoJsonMultiPoint(points);
        assertEquals("MultiPoint", mp.getType());
    }

    @Test
    public void testGetPoints() {
        List<GeoJsonPoint> points = new ArrayList<>();
        points.add(new GeoJsonPoint(new LatLng(0, 0)));
        points.add(new GeoJsonPoint(new LatLng(5, 5)));
        points.add(new GeoJsonPoint(new LatLng(10, 10)));
        mp = new GeoJsonMultiPoint(points);
        assertEquals(points, mp.getPoints());

        points = new ArrayList<>();
        mp = new GeoJsonMultiPoint(points);
        assertEquals(new ArrayList<GeoJsonPoint>(), mp.getPoints());

        try {
            mp = new GeoJsonMultiPoint(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Geometries cannot be null", e.getMessage());
        }
    }
}
