package org.fpsrobotics.sensors;

import com.kauailabs.navx.frc.AHRS;

public class AccelerometerNavX implements IAccelerometer
{
	private AHRS ahrs;
	private final static double GRAVITY = 9.80;

	public AccelerometerNavX(AHRS ahrs)
	{
		this.ahrs = ahrs;
	}

	@Override
	public double getX()
	{
		return ahrs.getWorldLinearAccelX() * GRAVITY;
	}

	@Override
	public double getY()
	{
		return ahrs.getWorldLinearAccelY() * GRAVITY;
	}

	@Override
	public double getZ()
	{
		return ahrs.getWorldLinearAccelZ() * GRAVITY;
	}

	@Override
	public void reset()
	{
		ahrs.resetDisplacement();
	}

	@Override
	public double getResultant()
	{
		return Math.pow(Math.pow(getX(), 2) + Math.pow(getY(), 2), 0.5);
	}

}
