package spittr.data;

import java.util.List;

import spittr.Spittle;

/**
 * 
 * @author HNN - 6 févr. 2020 23:38:20
 */
public interface SpittleRepository {
	List<Spittle> findSpittles(long max, int count);

	Spittle findOne(long spittleId);
}
