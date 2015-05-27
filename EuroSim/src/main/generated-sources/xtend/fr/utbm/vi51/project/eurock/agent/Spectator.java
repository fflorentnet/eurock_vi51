package fr.utbm.vi51.project.eurock.agent;

import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Agent;
import java.util.UUID;

/**
 * @author Thomas
 */
@SuppressWarnings("all")
public class Spectator extends Agent {
  /**
   * Construct an agent.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   */
  @Generated
  public Spectator(final UUID parentID) {
    super(parentID, null);
  }
  
  /**
   * Construct an agent.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   * @param agentID - identifier of the agent. If <code>null</code> the agent identifier will be computed randomly.
   */
  @Generated
  public Spectator(final UUID parentID, final UUID agentID) {
    super(parentID, agentID);
  }
}
