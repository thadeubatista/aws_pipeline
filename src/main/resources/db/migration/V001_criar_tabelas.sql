SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `aws` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;

CREATE TABLE IF NOT EXISTS `fenix`.`BANCO` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `CODIGO` VARCHAR(10) NULL DEFAULT NULL COMMENT '{\"cardinalidade\":\"\",\"crud\":\"\",\"side\":\"\",\"cascade\":false,\"orphanRemoval\":false,\"campoLookup\":\"\",\"label\":\"Código\",\"labelText\":\"Código\",\"validacao\":\"\",\"obrigatorio\":true,\"tooltip\":\"Código\",\"linhaBootstrap\":1,\"colunaBootstrap\":1,\"sizesBootstrap\":\"col-12 col-md-4\",\"tipoControle\":{\"tipo\":\"textFormField\",\"keyboardType\":\"number\",\"mascara\":\"\"}}\n',
  `NOME` VARCHAR(100) NULL DEFAULT NULL COMMENT '{\"cardinalidade\":\"\",\"crud\":\"\",\"side\":\"\",\"cascade\":false,\"orphanRemoval\":false,\"campoLookup\":\"\",\"label\":\"Nome\",\"labelText\":\"Nome\",\"validacao\":\"\",\"obrigatorio\":true,\"tooltip\":\"Nome\",\"linhaBootstrap\":1,\"colunaBootstrap\":2,\"sizesBootstrap\":\"col-12 col-md-8\",\"tipoControle\":{\"tipo\":\"textFormField\",\"keyboardType\":\"\",\"mascara\":\"\"}}',
  `URL` VARCHAR(250) NULL DEFAULT NULL COMMENT '{\"cardinalidade\":\"\",\"crud\":\"\",\"side\":\"\",\"cascade\":false,\"orphanRemoval\":false,\"campoLookup\":\"\",\"label\":\"URL\",\"labelText\":\"URL\",\"validacao\":\"\",\"obrigatorio\":false,\"tooltip\":\"URL\",\"linhaBootstrap\":2,\"colunaBootstrap\":1,\"sizesBootstrap\":\"col-12\",\"tipoControle\":{\"tipo\":\"textFormField\",\"keyboardType\":\"url\",\"mascara\":\"\"}}',
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;