package ch3.enable;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.scheduling.annotation.ProxyAsyncConfiguration;

public class AsyncConfigurationSelector extends AdviceModeImportSelector<EnableAsync> {
	private static final String ASYNC_EXECUTION_ASPECT_CONFIGURATION_CLASS_NAME = "org.springframework.scheduling.aspectj.AspectJAsyncConfiguration";

	@Override
	protected String[] selectImports(AdviceMode adviceMode) {
		// TODO Auto-generated method stub
		switch (adviceMode) {
		case PROXY:
			return new String[] { ProxyAsyncConfiguration.class.getName() };
		case ASPECTJ:
			return new String[] { ASYNC_EXECUTION_ASPECT_CONFIGURATION_CLASS_NAME };
		default:
			return null;
		}

	}

}
