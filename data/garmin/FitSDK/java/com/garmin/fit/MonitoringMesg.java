////////////////////////////////////////////////////////////////////////////////
// The following FIT Protocol software provided may be used with FIT protocol
// devices only and remains the copyrighted property of Garmin Canada Inc.
// The software is being provided on an "as-is" basis and as an accommodation,
// and therefore all warranties, representations, or guarantees of any kind
// (whether express, implied or statutory) including, without limitation,
// warranties of merchantability, non-infringement, or fitness for a particular
// purpose, are specifically disclaimed.
//
// Copyright 2020 Garmin Canada Inc.
////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.40Release
// Tag = production/akw/21.40.00-0-g813c158
////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;
import java.math.BigInteger;


public class MonitoringMesg extends Mesg {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int DeviceIndexFieldNum = 0;
    
    public static final int CaloriesFieldNum = 1;
    
    public static final int DistanceFieldNum = 2;
    
    public static final int CyclesFieldNum = 3;
    
    public static final int ActiveTimeFieldNum = 4;
    
    public static final int ActivityTypeFieldNum = 5;
    
    public static final int ActivitySubtypeFieldNum = 6;
    
    public static final int ActivityLevelFieldNum = 7;
    
    public static final int Distance16FieldNum = 8;
    
    public static final int Cycles16FieldNum = 9;
    
    public static final int ActiveTime16FieldNum = 10;
    
    public static final int LocalTimestampFieldNum = 11;
    
    public static final int TemperatureFieldNum = 12;
    
    public static final int TemperatureMinFieldNum = 14;
    
    public static final int TemperatureMaxFieldNum = 15;
    
    public static final int ActivityTimeFieldNum = 16;
    
    public static final int ActiveCaloriesFieldNum = 19;
    
    public static final int CurrentActivityTypeIntensityFieldNum = 24;
    
    public static final int TimestampMin8FieldNum = 25;
    
    public static final int Timestamp16FieldNum = 26;
    
    public static final int HeartRateFieldNum = 27;
    
    public static final int IntensityFieldNum = 28;
    
    public static final int DurationMinFieldNum = 29;
    
    public static final int DurationFieldNum = 30;
    
    public static final int AscentFieldNum = 31;
    
    public static final int DescentFieldNum = 32;
    
    public static final int ModerateActivityMinutesFieldNum = 33;
    
    public static final int VigorousActivityMinutesFieldNum = 34;
    

    protected static final  Mesg monitoringMesg;
    static {
        int field_index = 0;
        int subfield_index = 0;
        // monitoring
        monitoringMesg = new Mesg("monitoring", MesgNum.MONITORING);
        monitoringMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        field_index++;
        monitoringMesg.addField(new Field("device_index", DeviceIndexFieldNum, 2, 1, 0, "", false, Profile.Type.DEVICE_INDEX));
        field_index++;
        monitoringMesg.addField(new Field("calories", CaloriesFieldNum, 132, 1, 0, "kcal", false, Profile.Type.UINT16));
        field_index++;
        monitoringMesg.addField(new Field("distance", DistanceFieldNum, 134, 100, 0, "m", false, Profile.Type.UINT32));
        field_index++;
        monitoringMesg.addField(new Field("cycles", CyclesFieldNum, 134, 2, 0, "cycles", false, Profile.Type.UINT32));
        subfield_index = 0;
        monitoringMesg.fields.get(field_index).subFields.add(new SubField("steps", 134, 1, 0, "steps"));
        monitoringMesg.fields.get(field_index).subFields.get(subfield_index).addMap(5, 6);
        monitoringMesg.fields.get(field_index).subFields.get(subfield_index).addMap(5, 1);
        subfield_index++;
        monitoringMesg.fields.get(field_index).subFields.add(new SubField("strokes", 134, 2, 0, "strokes"));
        monitoringMesg.fields.get(field_index).subFields.get(subfield_index).addMap(5, 2);
        monitoringMesg.fields.get(field_index).subFields.get(subfield_index).addMap(5, 5);
        subfield_index++;
        field_index++;
        monitoringMesg.addField(new Field("active_time", ActiveTimeFieldNum, 134, 1000, 0, "s", false, Profile.Type.UINT32));
        field_index++;
        monitoringMesg.addField(new Field("activity_type", ActivityTypeFieldNum, 0, 1, 0, "", false, Profile.Type.ACTIVITY_TYPE));
        field_index++;
        monitoringMesg.addField(new Field("activity_subtype", ActivitySubtypeFieldNum, 0, 1, 0, "", false, Profile.Type.ACTIVITY_SUBTYPE));
        field_index++;
        monitoringMesg.addField(new Field("activity_level", ActivityLevelFieldNum, 0, 1, 0, "", false, Profile.Type.ACTIVITY_LEVEL));
        field_index++;
        monitoringMesg.addField(new Field("distance_16", Distance16FieldNum, 132, 1, 0, "100 * m", false, Profile.Type.UINT16));
        field_index++;
        monitoringMesg.addField(new Field("cycles_16", Cycles16FieldNum, 132, 1, 0, "2 * cycles (steps)", false, Profile.Type.UINT16));
        field_index++;
        monitoringMesg.addField(new Field("active_time_16", ActiveTime16FieldNum, 132, 1, 0, "s", false, Profile.Type.UINT16));
        field_index++;
        monitoringMesg.addField(new Field("local_timestamp", LocalTimestampFieldNum, 134, 1, 0, "", false, Profile.Type.LOCAL_DATE_TIME));
        field_index++;
        monitoringMesg.addField(new Field("temperature", TemperatureFieldNum, 131, 100, 0, "C", false, Profile.Type.SINT16));
        field_index++;
        monitoringMesg.addField(new Field("temperature_min", TemperatureMinFieldNum, 131, 100, 0, "C", false, Profile.Type.SINT16));
        field_index++;
        monitoringMesg.addField(new Field("temperature_max", TemperatureMaxFieldNum, 131, 100, 0, "C", false, Profile.Type.SINT16));
        field_index++;
        monitoringMesg.addField(new Field("activity_time", ActivityTimeFieldNum, 132, 1, 0, "minutes", false, Profile.Type.UINT16));
        field_index++;
        monitoringMesg.addField(new Field("active_calories", ActiveCaloriesFieldNum, 132, 1, 0, "kcal", false, Profile.Type.UINT16));
        field_index++;
        monitoringMesg.addField(new Field("current_activity_type_intensity", CurrentActivityTypeIntensityFieldNum, 13, 1, 0, "", false, Profile.Type.BYTE));
        monitoringMesg.fields.get(field_index).components.add(new FieldComponent(5, false, 5, 1, 0)); // activity_type
        monitoringMesg.fields.get(field_index).components.add(new FieldComponent(28, false, 3, 1, 0)); // intensity
        field_index++;
        monitoringMesg.addField(new Field("timestamp_min_8", TimestampMin8FieldNum, 2, 1, 0, "min", false, Profile.Type.UINT8));
        field_index++;
        monitoringMesg.addField(new Field("timestamp_16", Timestamp16FieldNum, 132, 1, 0, "s", false, Profile.Type.UINT16));
        field_index++;
        monitoringMesg.addField(new Field("heart_rate", HeartRateFieldNum, 2, 1, 0, "bpm", false, Profile.Type.UINT8));
        field_index++;
        monitoringMesg.addField(new Field("intensity", IntensityFieldNum, 2, 10, 0, "", false, Profile.Type.UINT8));
        field_index++;
        monitoringMesg.addField(new Field("duration_min", DurationMinFieldNum, 132, 1, 0, "min", false, Profile.Type.UINT16));
        field_index++;
        monitoringMesg.addField(new Field("duration", DurationFieldNum, 134, 1, 0, "s", false, Profile.Type.UINT32));
        field_index++;
        monitoringMesg.addField(new Field("ascent", AscentFieldNum, 134, 1000, 0, "m", false, Profile.Type.UINT32));
        field_index++;
        monitoringMesg.addField(new Field("descent", DescentFieldNum, 134, 1000, 0, "m", false, Profile.Type.UINT32));
        field_index++;
        monitoringMesg.addField(new Field("moderate_activity_minutes", ModerateActivityMinutesFieldNum, 132, 1, 0, "minutes", false, Profile.Type.UINT16));
        field_index++;
        monitoringMesg.addField(new Field("vigorous_activity_minutes", VigorousActivityMinutesFieldNum, 132, 1, 0, "minutes", false, Profile.Type.UINT16));
        field_index++;
    }

    public MonitoringMesg() {
        super(Factory.createMesg(MesgNum.MONITORING));
    }

    public MonitoringMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get timestamp field
     * Units: s
     * Comment: Must align to logging interval, for example, time must be 00:00:00 for daily log.
     *
     * @return timestamp
     */
    public DateTime getTimestamp() {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set timestamp field
     * Units: s
     * Comment: Must align to logging interval, for example, time must be 00:00:00 for daily log.
     *
     * @param timestamp
     */
    public void setTimestamp(DateTime timestamp) {
        setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get device_index field
     * Comment: Associates this data to device_info message.  Not required for file with single device (sensor).
     *
     * @return device_index
     */
    public Short getDeviceIndex() {
        return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set device_index field
     * Comment: Associates this data to device_info message.  Not required for file with single device (sensor).
     *
     * @param deviceIndex
     */
    public void setDeviceIndex(Short deviceIndex) {
        setFieldValue(0, 0, deviceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get calories field
     * Units: kcal
     * Comment: Accumulated total calories.  Maintained by MonitoringReader for each activity_type.  See SDK documentation
     *
     * @return calories
     */
    public Integer getCalories() {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set calories field
     * Units: kcal
     * Comment: Accumulated total calories.  Maintained by MonitoringReader for each activity_type.  See SDK documentation
     *
     * @param calories
     */
    public void setCalories(Integer calories) {
        setFieldValue(1, 0, calories, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get distance field
     * Units: m
     * Comment: Accumulated distance.  Maintained by MonitoringReader for each activity_type.  See SDK documentation.
     *
     * @return distance
     */
    public Float getDistance() {
        return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set distance field
     * Units: m
     * Comment: Accumulated distance.  Maintained by MonitoringReader for each activity_type.  See SDK documentation.
     *
     * @param distance
     */
    public void setDistance(Float distance) {
        setFieldValue(2, 0, distance, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get cycles field
     * Units: cycles
     * Comment: Accumulated cycles.  Maintained by MonitoringReader for each activity_type.  See SDK documentation.
     *
     * @return cycles
     */
    public Float getCycles() {
        return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set cycles field
     * Units: cycles
     * Comment: Accumulated cycles.  Maintained by MonitoringReader for each activity_type.  See SDK documentation.
     *
     * @param cycles
     */
    public void setCycles(Float cycles) {
        setFieldValue(3, 0, cycles, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get steps field
     * Units: steps
     *
     * @return steps
     */
    public Long getSteps() {
        return getFieldLongValue(3, 0, Profile.SubFields.MONITORING_MESG_CYCLES_FIELD_STEPS);
    }

    /**
     * Set steps field
     * Units: steps
     *
     * @param steps
     */
    public void setSteps(Long steps) {
        setFieldValue(3, 0, steps, Profile.SubFields.MONITORING_MESG_CYCLES_FIELD_STEPS);
    }

    /**
     * Get strokes field
     * Units: strokes
     *
     * @return strokes
     */
    public Float getStrokes() {
        return getFieldFloatValue(3, 0, Profile.SubFields.MONITORING_MESG_CYCLES_FIELD_STROKES);
    }

    /**
     * Set strokes field
     * Units: strokes
     *
     * @param strokes
     */
    public void setStrokes(Float strokes) {
        setFieldValue(3, 0, strokes, Profile.SubFields.MONITORING_MESG_CYCLES_FIELD_STROKES);
    }

    /**
     * Get active_time field
     * Units: s
     *
     * @return active_time
     */
    public Float getActiveTime() {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set active_time field
     * Units: s
     *
     * @param activeTime
     */
    public void setActiveTime(Float activeTime) {
        setFieldValue(4, 0, activeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get activity_type field
     *
     * @return activity_type
     */
    public ActivityType getActivityType() {
        Short value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return ActivityType.getByValue(value);
    }

    /**
     * Set activity_type field
     *
     * @param activityType
     */
    public void setActivityType(ActivityType activityType) {
        setFieldValue(5, 0, activityType.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get activity_subtype field
     *
     * @return activity_subtype
     */
    public ActivitySubtype getActivitySubtype() {
        Short value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return ActivitySubtype.getByValue(value);
    }

    /**
     * Set activity_subtype field
     *
     * @param activitySubtype
     */
    public void setActivitySubtype(ActivitySubtype activitySubtype) {
        setFieldValue(6, 0, activitySubtype.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get activity_level field
     *
     * @return activity_level
     */
    public ActivityLevel getActivityLevel() {
        Short value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return ActivityLevel.getByValue(value);
    }

    /**
     * Set activity_level field
     *
     * @param activityLevel
     */
    public void setActivityLevel(ActivityLevel activityLevel) {
        setFieldValue(7, 0, activityLevel.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get distance_16 field
     * Units: 100 * m
     *
     * @return distance_16
     */
    public Integer getDistance16() {
        return getFieldIntegerValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set distance_16 field
     * Units: 100 * m
     *
     * @param distance16
     */
    public void setDistance16(Integer distance16) {
        setFieldValue(8, 0, distance16, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get cycles_16 field
     * Units: 2 * cycles (steps)
     *
     * @return cycles_16
     */
    public Integer getCycles16() {
        return getFieldIntegerValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set cycles_16 field
     * Units: 2 * cycles (steps)
     *
     * @param cycles16
     */
    public void setCycles16(Integer cycles16) {
        setFieldValue(9, 0, cycles16, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get active_time_16 field
     * Units: s
     *
     * @return active_time_16
     */
    public Integer getActiveTime16() {
        return getFieldIntegerValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set active_time_16 field
     * Units: s
     *
     * @param activeTime16
     */
    public void setActiveTime16(Integer activeTime16) {
        setFieldValue(10, 0, activeTime16, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get local_timestamp field
     * Comment: Must align to logging interval, for example, time must be 00:00:00 for daily log.
     *
     * @return local_timestamp
     */
    public Long getLocalTimestamp() {
        return getFieldLongValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set local_timestamp field
     * Comment: Must align to logging interval, for example, time must be 00:00:00 for daily log.
     *
     * @param localTimestamp
     */
    public void setLocalTimestamp(Long localTimestamp) {
        setFieldValue(11, 0, localTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get temperature field
     * Units: C
     * Comment: Avg temperature during the logging interval ended at timestamp
     *
     * @return temperature
     */
    public Float getTemperature() {
        return getFieldFloatValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set temperature field
     * Units: C
     * Comment: Avg temperature during the logging interval ended at timestamp
     *
     * @param temperature
     */
    public void setTemperature(Float temperature) {
        setFieldValue(12, 0, temperature, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get temperature_min field
     * Units: C
     * Comment: Min temperature during the logging interval ended at timestamp
     *
     * @return temperature_min
     */
    public Float getTemperatureMin() {
        return getFieldFloatValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set temperature_min field
     * Units: C
     * Comment: Min temperature during the logging interval ended at timestamp
     *
     * @param temperatureMin
     */
    public void setTemperatureMin(Float temperatureMin) {
        setFieldValue(14, 0, temperatureMin, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get temperature_max field
     * Units: C
     * Comment: Max temperature during the logging interval ended at timestamp
     *
     * @return temperature_max
     */
    public Float getTemperatureMax() {
        return getFieldFloatValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set temperature_max field
     * Units: C
     * Comment: Max temperature during the logging interval ended at timestamp
     *
     * @param temperatureMax
     */
    public void setTemperatureMax(Float temperatureMax) {
        setFieldValue(15, 0, temperatureMax, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Integer[] getActivityTime() {
        
        return getFieldIntegerValues(16, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of activity_time
     */
    public int getNumActivityTime() {
        return getNumFieldValues(16, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get activity_time field
     * Units: minutes
     * Comment: Indexed using minute_activity_level enum
     *
     * @param index of activity_time
     * @return activity_time
     */
    public Integer getActivityTime(int index) {
        return getFieldIntegerValue(16, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set activity_time field
     * Units: minutes
     * Comment: Indexed using minute_activity_level enum
     *
     * @param index of activity_time
     * @param activityTime
     */
    public void setActivityTime(int index, Integer activityTime) {
        setFieldValue(16, index, activityTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get active_calories field
     * Units: kcal
     *
     * @return active_calories
     */
    public Integer getActiveCalories() {
        return getFieldIntegerValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set active_calories field
     * Units: kcal
     *
     * @param activeCalories
     */
    public void setActiveCalories(Integer activeCalories) {
        setFieldValue(19, 0, activeCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get current_activity_type_intensity field
     * Comment: Indicates single type / intensity for duration since last monitoring message.
     *
     * @return current_activity_type_intensity
     */
    public Byte getCurrentActivityTypeIntensity() {
        return getFieldByteValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set current_activity_type_intensity field
     * Comment: Indicates single type / intensity for duration since last monitoring message.
     *
     * @param currentActivityTypeIntensity
     */
    public void setCurrentActivityTypeIntensity(Byte currentActivityTypeIntensity) {
        setFieldValue(24, 0, currentActivityTypeIntensity, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get timestamp_min_8 field
     * Units: min
     *
     * @return timestamp_min_8
     */
    public Short getTimestampMin8() {
        return getFieldShortValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set timestamp_min_8 field
     * Units: min
     *
     * @param timestampMin8
     */
    public void setTimestampMin8(Short timestampMin8) {
        setFieldValue(25, 0, timestampMin8, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get timestamp_16 field
     * Units: s
     *
     * @return timestamp_16
     */
    public Integer getTimestamp16() {
        return getFieldIntegerValue(26, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set timestamp_16 field
     * Units: s
     *
     * @param timestamp16
     */
    public void setTimestamp16(Integer timestamp16) {
        setFieldValue(26, 0, timestamp16, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get heart_rate field
     * Units: bpm
     *
     * @return heart_rate
     */
    public Short getHeartRate() {
        return getFieldShortValue(27, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set heart_rate field
     * Units: bpm
     *
     * @param heartRate
     */
    public void setHeartRate(Short heartRate) {
        setFieldValue(27, 0, heartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get intensity field
     *
     * @return intensity
     */
    public Float getIntensity() {
        return getFieldFloatValue(28, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set intensity field
     *
     * @param intensity
     */
    public void setIntensity(Float intensity) {
        setFieldValue(28, 0, intensity, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get duration_min field
     * Units: min
     *
     * @return duration_min
     */
    public Integer getDurationMin() {
        return getFieldIntegerValue(29, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set duration_min field
     * Units: min
     *
     * @param durationMin
     */
    public void setDurationMin(Integer durationMin) {
        setFieldValue(29, 0, durationMin, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get duration field
     * Units: s
     *
     * @return duration
     */
    public Long getDuration() {
        return getFieldLongValue(30, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set duration field
     * Units: s
     *
     * @param duration
     */
    public void setDuration(Long duration) {
        setFieldValue(30, 0, duration, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get ascent field
     * Units: m
     *
     * @return ascent
     */
    public Float getAscent() {
        return getFieldFloatValue(31, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set ascent field
     * Units: m
     *
     * @param ascent
     */
    public void setAscent(Float ascent) {
        setFieldValue(31, 0, ascent, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get descent field
     * Units: m
     *
     * @return descent
     */
    public Float getDescent() {
        return getFieldFloatValue(32, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set descent field
     * Units: m
     *
     * @param descent
     */
    public void setDescent(Float descent) {
        setFieldValue(32, 0, descent, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get moderate_activity_minutes field
     * Units: minutes
     *
     * @return moderate_activity_minutes
     */
    public Integer getModerateActivityMinutes() {
        return getFieldIntegerValue(33, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set moderate_activity_minutes field
     * Units: minutes
     *
     * @param moderateActivityMinutes
     */
    public void setModerateActivityMinutes(Integer moderateActivityMinutes) {
        setFieldValue(33, 0, moderateActivityMinutes, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get vigorous_activity_minutes field
     * Units: minutes
     *
     * @return vigorous_activity_minutes
     */
    public Integer getVigorousActivityMinutes() {
        return getFieldIntegerValue(34, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set vigorous_activity_minutes field
     * Units: minutes
     *
     * @param vigorousActivityMinutes
     */
    public void setVigorousActivityMinutes(Integer vigorousActivityMinutes) {
        setFieldValue(34, 0, vigorousActivityMinutes, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
